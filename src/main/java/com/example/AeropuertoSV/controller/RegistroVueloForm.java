package com.example.AeropuertoSV.controller;

import java.time.LocalDate;
import java.time.LocalTime;


public class RegistroVueloForm {


	private String nVuelo;
	private LocalDate fecha;
	private LocalTime hora;
	private String origen;
	private String destino;
	private String estado;
	private String avionAsignado;
	
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
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAvionAsignado() {
		return avionAsignado;
	}
	public void setAvionAsignado(String avionAsignado) {
		this.avionAsignado = avionAsignado;
	}
	
	
	
}
