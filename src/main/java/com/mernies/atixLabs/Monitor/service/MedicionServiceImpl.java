package com.mernies.atixLabs.Monitor.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mernies.atixLabs.Monitor.bean.Medicion;
import com.mernies.atixLabs.Monitor.dao.MedicionDao;

@Service("medicionServiceImpl")
public class MedicionServiceImpl implements MedicionService{
	private static final Logger logger = LogManager.getLogger(MedicionServiceImpl.class); 
	
	@Autowired
	@Qualifier("medicionDaoListImpl")
	private MedicionDao medicionDao;
	
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
	}

}
