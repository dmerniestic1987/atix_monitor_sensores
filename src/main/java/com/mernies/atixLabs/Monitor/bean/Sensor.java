package com.mernies.atixLabs.Monitor.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representa a unos de los sensores IOT
 * @author diego
 *
 */
public class Sensor implements Serializable {
	private static final long serialVersionUID = -7766447114711855732L;
	private String sensorId;
	
	public Sensor(String sensorId) {
		super();
		this.sensorId = sensorId;
	}
	
	@JsonProperty("sensorId")
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	} 
	
	@JsonIgnore
	public Medicion medir(BigDecimal medicion) {
		Medicion m = new Medicion(new Date(), this.sensorId, medicion);
		return m;		
	}
}
