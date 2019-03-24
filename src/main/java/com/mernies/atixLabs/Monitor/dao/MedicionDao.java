package com.mernies.atixLabs.Monitor.dao;

import java.math.BigDecimal;
import java.util.List;

import com.mernies.atixLabs.Monitor.bean.Medicion;

public interface MedicionDao {
	public List<Medicion> getMediciones();
	/**
	 * Guarda una medición
	 * @param medicion
	 */
	public void saveMedicion(Medicion medicion);
	
	/**
	 * Calcula el valor medio de las mediciones
	 */
	public void calcularIndicadores();
	
	/**
	 * Obtiene el valor mínimo de las mediciones
	 * @return valorMinimo
	 */
	public BigDecimal getValorMinimo();
	
	
	/**
	 * Obtiene el valor máximo de las mediciones
	 * @return valorMaximo
	 */
	public BigDecimal getValorMaximo();
	
	/**
	 * Obtiene el valor medio de las mediciones
	 * @return valorMedio
	 */
	public BigDecimal getValorMedio();
	
	/**
	 * Limpia las mediciones
	 */
	public void cleanMediciones();
}
