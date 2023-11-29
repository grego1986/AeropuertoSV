package com.example.AeropuertoSV.controller;

import java.time.LocalDate;
import java.time.LocalTime;



public class RegistroVueloForm {


	private String nVuelo;
	private LocalDate fecha;
	private LocalTime hora;
	private Integer paisOrigen;
	private Integer origen;
	private Integer paisDestino;
	private Integer destino;
	private String estado;
	private Long avionAsignado;
	
		
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public Long getAvionAsignado() {
		return avionAsignado;
	}

	public void setAvionAsignado(Long avionAsignado) {
		this.avionAsignado = avionAsignado;
	}

	public Integer getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(Integer paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public Integer getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(Integer paisDestino) {
		this.paisDestino = paisDestino;
	}

	@Override
	public String toString() {
		return "RegistroVueloForm [nVuelo=" + nVuelo + ", fecha=" + fecha + ", hora=" + hora + ", paisOrigen="
				+ paisOrigen + ", origen=" + origen + ", paisDestino=" + paisDestino + ", destino=" + destino
				+ ", estado=" + estado + ", avionAsignado=" + avionAsignado + "]";
	}

	
	
}
