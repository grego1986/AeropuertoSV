package com.example.AeropuertoSV.controller;

import java.time.LocalDate;
import java.time.LocalTime;

public class GrillaConsulta {

	private LocalDate fecha;
	private LocalTime hora;
	private String nVuelo;
	private String tipoVuelo;
	private String estado;
	private Long asientos;
	
	public GrillaConsulta(LocalDate fecha, LocalTime hora, String nVuelo, String tipoVuelo, String estado,
			Long asientos) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.nVuelo = nVuelo;
		this.tipoVuelo = tipoVuelo;
		this.estado = estado;
		this.asientos = asientos;
	}

	public GrillaConsulta() {
		super();
	}

	public GrillaConsulta(LocalTime hora2, LocalDate fecha2, String getnVuelo, String tipo, Integer asientos2) {
		// TODO Auto-generated constructor stub
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

	public String getnVuelo() {
		return nVuelo;
	}

	public void setnVuelo(String nVuelo) {
		this.nVuelo = nVuelo;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getAsientos() {
		return asientos;
	}

	public void setAsientos(Long asientos) {
		this.asientos = asientos;
	}
	
	
	
}
