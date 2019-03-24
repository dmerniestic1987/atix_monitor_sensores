package com.mernies.atixLabs.Monitor.service;

import java.math.BigDecimal;

import com.mernies.atixLabs.Monitor.bean.Medicion;

/**
 * Capa de servicios para monitor de mediciones
 * @author diego
 *
 */
public interface MedicionService {
	
	/**
	 * Guarda una nueva medición
	 * @param medicion
	 */
	public void saveMedicion(Medicion medicion);
	
	/**
	 * Calcula los indicadores
	 */
	public void calcularIndicadores();
	
	/**
	 * Obtiene el valor medio
	 * @return valorMedio
	 */
	public BigDecimal getValorMedio();
	
	/**
	 * Obtiene el valor mínimo
	 * @return valorMinimo
	 */
	public BigDecimal getValorMinimo();
	
	/**
	 * Obtiene el valor máximo
	 * @return valorMaximo
	 */
	public BigDecimal getValorMaximo();
	
	
}
