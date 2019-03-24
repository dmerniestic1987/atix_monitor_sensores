package com.mernies.atixLabs.Monitor.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mernies.atixLabs.Monitor.bean.Medicion;
import com.mernies.atixLabs.Monitor.bean.MedicionStatus;
import com.mernies.atixLabs.Monitor.service.MedicionService;
import com.mernies.atixLabs.Monitor.util.JsonUtil;

/**
 * Controller que permite registrar las mediciones y consultar los posibles errores 
 * detectados en una medición a través de una página web. 
 * @author diego
 *
 */
@Controller
public class MedicionController {
	private static final Logger logger = LogManager.getLogger(MedicionController.class);
	
	@Autowired
	@Qualifier("medicionServiceImpl")
	private MedicionService medicionService;
	
	@PostMapping(path = "/medicion", consumes = "application/json", produces = "application/json")
	public @ResponseBody MedicionStatus saveMedicion(@RequestBody Medicion medicion) {
		logger.info("JSON INPUT: " + JsonUtil.toJsonString(medicion));
		try {
			this.medicionService.saveMedicion(medicion);
			return new MedicionStatus("OK", "OK");
		} catch (Exception e) {
			logger.error(e);
			return new MedicionStatus("ERROR", e.getMessage());
		}
		
	}
	
    @GetMapping("/status")
    public String greeting(Model model) {
        model.addAttribute("erroresIndicadores", this.medicionService.getErroresIndicadores());
        return "status";
    }

}
