package com.mernies.atixLabs.Monitor.controller;

import java.math.BigDecimal;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mernies.atixLabs.Monitor.bean.Sensor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMedicionController {
	private static final Logger logger = LogManager.getLogger(TestMedicionController.class);
	
	@Autowired
	private MedicionController medicionController;
	
	@Test
	public void testSaveMedicion() throws Exception{
		logger.info("testSaveMedicion()");
		Sensor sensor1 = new Sensor("S1");
		Random rand = new Random();
		medicionController.saveMedicion(sensor1.medir(new BigDecimal(rand.nextInt())));		
		medicionController.saveMedicion(sensor1.medir(new BigDecimal(rand.nextInt())));
		medicionController.saveMedicion(sensor1.medir(new BigDecimal(rand.nextInt())));
		medicionController.saveMedicion(sensor1.medir(new BigDecimal(rand.nextInt())));
		
	}
}
