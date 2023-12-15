package com.example.AeropuertoSV.controller;



public class formTicket{
	private Long id;
	private String nVuelo;
	private Long dniCliente;
	private String asiendoI;
	public formTicket(Long id, String nVuelo, Long dniCliente, String asiendoI) {
		super();
		this.id = id;
		this.nVuelo = nVuelo;
		this.dniCliente = dniCliente;
		this.asiendoI = asiendoI;
	}
	public formTicket() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getnVuelo() {
		return nVuelo;
	}
	public void setnVuelo(String nVuelo) {
		this.nVuelo = nVuelo;
	}
	public Long getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(Long dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getAsiendoI() {
		return asiendoI;
	}
	public void setAsiendoI(String asiendoI) {
		this.asiendoI = asiendoI;
	}
	
}