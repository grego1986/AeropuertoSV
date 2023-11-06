package com.example.AeropuertoSV.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "pasaportes")
public class Pasaporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nPasaporte")
	private String numeroPasaporte;
	@Column(name = "expiracion")
	private LocalDate Expiracion;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Pasaporte() {
		super();
	}

	public Pasaporte(long id, String numeroPasaporte, LocalDate expiracion, Cliente cliente) {
		super();
		this.id = id;
		this.numeroPasaporte = numeroPasaporte;
		Expiracion = expiracion;
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroPasaporte() {
		return numeroPasaporte;
	}

	public void setNumeroPasaporte(String numeroPasaporte) {
		this.numeroPasaporte = numeroPasaporte;
	}

	public LocalDate getExpiracion() {
		return Expiracion;
	}

	public void setExpiracion(LocalDate expiracion) {
		Expiracion = expiracion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
