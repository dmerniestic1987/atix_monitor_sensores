package com.mernies.atixLabs.Monitor.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mernies.atixLabs.Monitor.bean.ErrorIndicador;
import com.mernies.atixLabs.Monitor.bean.Medicion;
import com.mernies.atixLabs.Monitor.dao.MedicionDao;
import com.mernies.atixLabs.Monitor.util.MathUtil;

@Service("medicionServiceImpl")
public class MedicionServiceImpl implements MedicionService{
	private static final Logger logger = LogManager.getLogger(MedicionServiceImpl.class); 
	private static final BigDecimal DEFAULT_VALOR_MEDIO_MAX = new BigDecimal(400);
	private static final BigDecimal DEFAULT_DIFERENCIA_MAX_MIN = new BigDecimal(1000);
	
	@Value("${S}")
	private String S;
	
	@Value("${M}")
	private String M;
	
	
	@Autowired
	@Qualifier("medicionDaoListImpl")
	private MedicionDao medicionDao;
	
	private List<ErrorIndicador> erroresIndicadores;
	
	public MedicionServiceImpl() {
		super();
		this.erroresIndicadores = new ArrayList<>();
	}
	
	@Override
	public void saveMedicion(Medicion medicion) {
		logger.debug("saveMedicion - Guardando mediciones");
		this.medicionDao.saveMedicion(medicion);
		logger.debug("saveMedicion - Mediciones guardadas");
	}

	@Override
	public BigDecimal getValorMedio() {
		return this.medicionDao.getValorMedio();
	}

	@Override
	public BigDecimal getValorMinimo() {
		return this.medicionDao.getValorMinimo();
	}

	@Override
	public BigDecimal getValorMaximo() {
		return this.medicionDao.getValorMaximo();
	}

	@Scheduled(fixedRate = 30000)
	@Override
	public void calcularIndicadores() {
		logger.info("Calculando indicadores de mediciones");
		this.medicionDao.calcularIndicadores();
		StringBuffer sb = new StringBuffer();
		sb.append("Valor medio: " + this.getValorMedio() + "  ; ");
		sb.append("Valor mínimo: " + this.getValorMinimo() + "  ; ");
		sb.append("Valor máximo: " + this.getValorMaximo());
		logger.info(sb.toString());

		sb = new StringBuffer();
		sb.append("S (diferencia MAX MIN): " + S + "  ; ");
		sb.append("M (Valor Medio): " + M + "  ; ");
		logger.info(sb.toString());
		checkErrorIndicadores();
	}
	
	/**
	 * Determina si hubo error en el cálculo de los indicadores
	 */
	private void checkErrorIndicadores() {
		BigDecimal valorMedioAceptado = MathUtil.toBigDecimal(this.M, DEFAULT_VALOR_MEDIO_MAX);
		BigDecimal diferenciaAceptada =  MathUtil.toBigDecimal(this.S, DEFAULT_DIFERENCIA_MAX_MIN);
		
		if ( this.getValorMedio().compareTo(valorMedioAceptado) == MathUtil.ES_MAYOR ) {
			erroresIndicadores.add(new ErrorIndicador( ErrorIndicador.ERROR_VALOR_MEDIO
													 , "El valor medio excedió el valor medio permitido (M) = " + valorMedioAceptado.toString()
													 , "Valor calculado: " + this.getValorMedio()) );
		}
		
		BigDecimal diferencia = this.getValorMaximo().subtract(this.getValorMinimo());
		if ( diferencia.compareTo(diferenciaAceptada) == MathUtil.ES_MAYOR) {
			erroresIndicadores.add(new ErrorIndicador( ErrorIndicador.ERROR_DIFERENCIA_MIN_MAX
					 , "La diferencia entre valores MIN y MAX el valor medio permitido (S) = " + diferenciaAceptada.toString()
					 , "Valor calculado: " + diferencia) );
		}
	}

	@Override
	public List<ErrorIndicador> getErroresIndicadores() {
		return this.erroresIndicadores;
	}

	@Override
	public void cleanMediciones() {
		this.medicionDao.cleanMediciones();
	}
}
