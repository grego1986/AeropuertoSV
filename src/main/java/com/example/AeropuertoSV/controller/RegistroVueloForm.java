package com.example.AeropuertoSV.controller;

import java.time.LocalDate;
import java.time.LocalTime;



public class RegistroVueloForm {


	private String nVuelo;
	private LocalDate fecha;
	private LocalTime hora;
	private Integer origen;
	private Integer destino;
	private Long avionAsignado;
	private String existe;
	private String tipoVuelo;
	private String precio;
	private String moneda;
	
	public RegistroVueloForm() {
		super();
	}
	
	public String getnVuelo() {
		return nVuelo;
	}
	public void setnVuelo(String nVuelo) {
		this.nVuelo = nVuelo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Integer getOrigen() {
		return origen;
	}
	public void setOrigen(Integer origen) {
		this.origen = origen;
	}
	public Integer getDestino() {
		return destino;
	}
	public void setDestino(Integer destino) {
		this.destino = destino;
	}
	
	public Long getAvionAsignado() {
		return avionAsignado;
	}

	public void setAvionAsignado(Long avionAsignado) {
		this.avionAsignado = avionAsignado;
	}

	
	
	public String getExiste() {
		return existe;
	}

	public void setExiste(String existe) {
		this.existe = existe;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	
	
}
