package com.mernies.atixLabs.Monitor.bean;

import java.io.Serializable;
import java.util.Date;

import com.mernies.atixLabs.Monitor.util.JsonUtil;

/**
 * Bean que representa un error en la medición
 * @author diego
 *
 */
public class ErrorIndicador implements Serializable{
	private static final long serialVersionUID = -3078020875993105920L;
	
	public static final String ERROR_VALOR_MEDIO = "ERROR_VALOR_MEDIO";
	public static final String ERROR_DIFERENCIA_MIN_MAX = "ERROR_DIFERENCIA_MIN_MAX";
	
	private Date horaError;
	private String codigo;
	private String descripcion;
	private String detalle;
	
	public ErrorIndicador() {
		super();
		this.horaError = new Date();
	}

	public ErrorIndicador(String codigo, String descripcion, String detalle) {
		super();
		this.horaError = new Date();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.detalle = detalle;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getHoraError() {
		return horaError;
	}

	public void setHoraError(Date horaError) {
		this.horaError = horaError;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return JsonUtil.toJsonString(this);
	}
}
