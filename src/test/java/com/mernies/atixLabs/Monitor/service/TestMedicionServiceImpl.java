package com.mernies.atixLabs.Monitor.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mernies.atixLabs.Monitor.bean.Sensor;
import com.mernies.atixLabs.Monitor.controller.TestMedicionController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMedicionServiceImpl {
	private static final Logger logger = LogManager.getLogger(TestMedicionController.class);
	
	@Autowired
	@Qualifier("medicionServiceImpl")
	private MedicionService medicionService;
	
	@Test
	public void testCalcularIndicadores() {
		BigDecimal valorMinimo = new BigDecimal(1);
		BigDecimal valorMaximo = new BigDecimal(10);
		
		BigDecimal acumulador = BigDecimal.ZERO; 
		for (int i = 1; i <= 10; i++) {
			Sensor s1 = new Sensor("S1");
			Sensor s2 = new Sensor("S2");
			
			if (i % 2 == 0) {
				medicionService.saveMedicion(s1.medir(new BigDecimal(i)));
			}
			else {
				medicionService.saveMedicion(s2.medir(new BigDecimal(i)));
			}
			
			acumulador = acumulador.add(new BigDecimal(i));
		}
		
		BigDecimal media = acumulador.divide(new BigDecimal(10), 5, BigDecimal.ROUND_FLOOR);
		
		
		assertTrue(media.compareTo(this.medicionService.getValorMedio()) == 0);
		assertTrue(valorMinimo.equals(this.medicionService.getValorMinimo()));
		assertTrue(valorMaximo.equals(this.medicionService.getValorMaximo()));
	}
}
