package com.example.AeropuertoSV.controller;

public class FormPrecio {

	private Double precio;
	private String tipoVuelo;
			
	public FormPrecio() {
		super();
	}

	public FormPrecio(Double precio, String tipoVuelo) {
		super();
		this.precio = precio;
		this.tipoVuelo = tipoVuelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}
	
	
}
