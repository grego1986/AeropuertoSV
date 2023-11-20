/**
 * 
 */
package com.example.AeropuertoSV.entity;

import jakarta.persistence.Column;
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
	private AsientoAvionId x;
	@OneToOne
	@Column(name="From")
	private Ciudad ciudadOrigen;
	@OneToOne
	@Column(name="To")
	private Ciudad ciudadDestino;
	//las XD
	@OneToOne
	@JoinColumn(name = "precioFinal")
	private Pasaje precioPasaje;
	
	public Ticket(long id, Cliente cliente, AsientoAvionId x, Ciudad ciudadOrigen, Ciudad ciudadDestino,
			Pasaje precioPasaje) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.x = x;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
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
	public AsientoAvionId getX() {
		return x;
	}
	public void setX(AsientoAvionId x) {
		this.x = x;
	}
	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public Pasaje getPrecioPasaje() {
		return precioPasaje;
	}
	public void setPrecioPasaje(Pasaje precioPasaje) {
		this.precioPasaje = precioPasaje;
	}
	


}
