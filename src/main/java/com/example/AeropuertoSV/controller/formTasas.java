package com.example.AeropuertoSV.controller;


public class formTasas{
	private int iva;
	private int tasa_nacional;
	private int tasa_internacional;
	private int cotizacion_dolar;
	
	public formTasas(int iva, int tasa_nacional, int tasa_internacional, int cotizacion_dolar) {
		super();
		this.iva = iva;
		this.tasa_nacional = tasa_nacional;
		this.tasa_internacional = tasa_internacional;
		this.cotizacion_dolar = cotizacion_dolar;
	}
	public formTasas() {
		super();
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getTasa_nacional() {
		return tasa_nacional;
	}
	public void setTasa_nacional(int tasa_nacional) {
		this.tasa_nacional = tasa_nacional;
	}
	public int getTasa_internacional() {
		return tasa_internacional;
	}
	public void setTasa_internacional(int tasa_internacional) {
		this.tasa_internacional = tasa_internacional;
	}
	public int getCotizacion_dolar() {
		return cotizacion_dolar;
	}
	public void setCotizacion_dolar(int cotizacion_dolar) {
		this.cotizacion_dolar = cotizacion_dolar;
	}
	
	
}