package com.example.AeropuertoSV.controller;

public class formCliente {
	private Long dni;

	public formCliente(long dni) {
		super();
		this.dni = dni;
	}

	public formCliente() {
		super();
	}
	public Long getDni() {
	    return this.dni != null ? this.dni.longValue() : null;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}
	
}
