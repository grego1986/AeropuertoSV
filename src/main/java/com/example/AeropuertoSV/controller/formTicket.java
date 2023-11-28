package com.example.AeropuertoSV.controller;

import com.example.AeropuertoSV.entity.Asiento;
import com.example.AeropuertoSV.entity.Cliente;
import com.example.AeropuertoSV.entity.Pasaje;

public class formTicket{
	private Long id;
	private Cliente c;
	private Asiento a;
	private Pasaje p;
	
	public formTicket() {
		super();
	}
	
	public formTicket(Long id, Cliente c, Asiento a, Pasaje p) {
		super();
		this.id = id;
		this.c = c;
		this.a = a;
		this.p = p;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}
	public Asiento getA() {
		return a;
	}
	public void setA(Asiento a) {
		this.a = a;
	}
	public Pasaje getP() {
		return p;
	}
	public void setP(Pasaje p) {
		this.p = p;
	}
	
	
}