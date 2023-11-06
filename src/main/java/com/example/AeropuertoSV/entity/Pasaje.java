package com.example.AeropuertoSV.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasajes")
public class Pasaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPasaje;
	@ManyToOne
	@JoinColumn(name = "vuelo_id")
	private Vuelo vuelo;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@Column(name = "precio_total")
	private double precioPasaje;
	
	
	public Pasaje() {
		super();
	}


	public Pasaje(long idPasaje, Vuelo vuelo, Cliente cliente, double precioPasaje) {
		super();
		this.idPasaje = idPasaje;
		this.vuelo = vuelo;
		this.cliente = cliente;
		this.precioPasaje = precioPasaje;
	}


	public long getIdPasaje() {
		return idPasaje;
	}


	public void setIdPasaje(long idPasaje) {
		this.idPasaje = idPasaje;
	}


	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public double getPrecioPasaje() {
		return precioPasaje;
	}


	public void setPrecioPasaje(double precioPasaje) {
		this.precioPasaje = precioPasaje;
	}


	@Override
	public String toString() {
		return "Pasaje [idPasaje=" + idPasaje + ", vuelo=" + vuelo + ", cliente=" + cliente + ", precioPasaje="
				+ precioPasaje + "]";
	}
	
	
	
}
