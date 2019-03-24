package com.mernies.atixLabs.Monitor.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		this.medicionDao.saveMedicion(medicion);
		this.medicionDao.calcularIndicadores();
		
		StringBuffer sb = new StringBuffer();
		sb.append("Save Medicion - ");
		sb.append("Valor medio: " + medicionDao.getValorMedio() + " - ");
		sb.append("Valor mínimo: " + medicionDao.getValorMinimo() + " - ");
		sb.append("Valor máximo: " + medicionDao.getValorMaximo());
		logger.info(sb.toString());
		
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

}
