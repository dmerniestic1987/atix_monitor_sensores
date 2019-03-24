package com.mernies.atixLabs.Monitor.util;

import java.math.BigDecimal;

public class MathUtil {
	public static final Integer ES_MENOR = -1; 
	public static final Integer ES_MAYOR = 1; 
	
	/**
	 * Transforma en String en un BigDecimal
	 * @param value
	 * @param defaultValue
	 * @return bigDecimalValue
	 */
	public static BigDecimal toBigDecimal(String value, BigDecimal defaultValue) {
		BigDecimal bigDecimalValue = null;
		try {
			bigDecimalValue = new BigDecimal(value);
		} catch (Exception e) {
			bigDecimalValue = defaultValue;
		}
		
		return bigDecimalValue;
	}
}
