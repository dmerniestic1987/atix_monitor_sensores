package com.mernies.atixLabs.Monitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitorApplication implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger(MonitorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("************* MONITOR DE SENSORES *************");
		logger.info("* Candidato: Diego Alejandro Mernies");
        
		for (String nombreArgumento : args.getOptionNames()){
            logger.info(nombreArgumento + "=" + args.getOptionValues(nombreArgumento));
            System.setProperty(nombreArgumento, args.getOptionValues(nombreArgumento).get(0));
        }
		
	}

}
