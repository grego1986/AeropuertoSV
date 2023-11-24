/**
 * 
 */
package com.example.AeropuertoSV.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "numeroAsiento")
	@JoinColumn(name = "avion")
	private Asiento x;
	//las XD
	@OneToOne
	@JoinColumn(name = "precioFinal")
	private Pasaje precioPasaje;
	
	
	public Ticket(long id, Cliente cliente, Asiento x, Pasaje precioPasaje) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.x = x;
		this.precioPasaje = precioPasaje;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Asiento getX() {
		return x;
	}
	public void setX(Asiento x) {
		this.x = x;
	}

	public Pasaje getPrecioPasaje() {
		return precioPasaje;
	}
	public void setPrecioPasaje(Pasaje precioPasaje) {
		this.precioPasaje = precioPasaje;
	}
	


}
