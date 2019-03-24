package com.mernies.atixLabs.Monitor.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.mernies.atixLabs.Monitor.bean.Medicion;
import com.mernies.atixLabs.Monitor.util.MathUtil;

/**
 * Implementación con un List
 * @author diego
 *
 */
@Repository("medicionDaoListImpl")
public class MedicionDaoListImpl implements MedicionDao{
	private static final Logger logger = LogManager.getLogger(MedicionDaoListImpl.class); 

	
	private List<Medicion> mediciones;
	private BigDecimal valorMedio; 
	private BigDecimal valorMinimo; 
	private BigDecimal valorMaximo; 
	
	
	public MedicionDaoListImpl() {
		super();
		mediciones = new ArrayList<Medicion>();
		valorMedio = BigDecimal.ZERO;
		valorMinimo = BigDecimal.ZERO;
		valorMaximo = BigDecimal.ZERO;
	}
	
	@Override
	public void calcularIndicadores() {
		
		if (!this.mediciones.isEmpty()) {
			BigDecimal auxAcumulador  = BigDecimal.ZERO;
			BigDecimal auxValorMinimo = this.mediciones.get(0).getMedicion();
			BigDecimal auxValorMaximo = this.mediciones.get(0).getMedicion();
			
			//Recorre las mediciones
			for (Medicion medicion : this.mediciones) {
				auxAcumulador = auxAcumulador.add(medicion.getMedicion());
				
				if ( medicion.getMedicion().compareTo(auxValorMinimo) == MathUtil.ES_MENOR ) {
					auxValorMinimo = medicion.getMedicion();
				}
				
				if ( medicion.getMedicion().compareTo(auxValorMaximo) == MathUtil.ES_MAYOR ) {
					auxValorMaximo = medicion.getMedicion();
				}
			}	
			
			this.valorMaximo = auxValorMaximo;
			this.valorMinimo = auxValorMinimo;
			this.valorMedio = auxAcumulador.divide(new BigDecimal(this.mediciones.size()), 5, BigDecimal.ROUND_FLOOR);
		}	
	}
	
	@Override
	public void saveMedicion(Medicion medicion) {
		logger.info("Save Medicion");
		mediciones.add(medicion);
	}

	@Override
	public BigDecimal getValorMinimo() {
		return this.valorMinimo;
	}

	@Override
	public BigDecimal getValorMaximo() {
		return this.valorMaximo;
	}

	@Override
	public BigDecimal getValorMedio() {
		return this.valorMedio;
	}

	@Override
	public List<Medicion> getMediciones() {
		return this.mediciones;
	}

	@Override
	public void cleanMediciones() {
		this.mediciones.clear();		
	}
}
