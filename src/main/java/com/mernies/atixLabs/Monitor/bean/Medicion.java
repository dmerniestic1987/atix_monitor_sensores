package com.mernies.atixLabs.Monitor.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representa a una medición de un sensor determiando
 * @author diego
 *
 */
public class Medicion implements Serializable {
	private static final long serialVersionUID = 233046376250973481L;
	private Date dateMedicion;
	private String sensorId;
	private BigDecimal medicion;
	
	public Medicion() {
		super();
	}
	
	public Medicion(Date dateMedicion, String sensorId, BigDecimal medicion) {
		super();
		this.dateMedicion = dateMedicion;
		this.sensorId = sensorId;
		this.medicion = medicion;
	}
	
	@JsonProperty("sensorId")
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	
	@JsonProperty("medicion")
	public BigDecimal getMedicion() {
		return medicion;
	}
	public void setMedicion(BigDecimal medicion) {
		this.medicion = medicion;
	}
	
	@JsonProperty("dateMedicion")
	public Date getDateMedicion() {
		return dateMedicion;
	}
	public void setDateMedicion(Date dateMedicion) {
		this.dateMedicion = dateMedicion;
	}
	@Override
	public String toString() {
		return "Medicion [dateMedicion=" + dateMedicion + ", sensorId=" + sensorId + ", medicion=" + medicion + "]";
	}	
}
