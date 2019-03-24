package com.mernies.atixLabs.Monitor.bean;

public class MedicionStatus {
	private String status;
	private String descripcion;
	
	public MedicionStatus(String status, String descripcion) {
		super();
		this.status = status;
		this.descripcion = descripcion;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
