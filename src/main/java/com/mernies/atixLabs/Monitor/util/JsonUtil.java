package com.mernies.atixLabs.Monitor.util;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utilidades para trabajar objetos JSON
 * @author diego
 *
 */
public class JsonUtil {
	private static final Logger logger = LogManager.getLogger(JsonUtil.class);
	public static String toJsonString(Serializable s) {
        try {
			ObjectMapper mapper = new ObjectMapper();
			String temp = mapper.writeValueAsString(s);
			return temp;
		} catch (Exception e) {
			logger.error("Error al transformar Objeto a String JSON", e);
			return null;
		}
	}
}
