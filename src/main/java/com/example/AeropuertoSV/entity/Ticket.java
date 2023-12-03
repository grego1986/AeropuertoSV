/**
 * 
 */
package com.example.AeropuertoSV.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne
    @JoinColumn(name = "asiento_id", referencedColumnName = "id")
	private Asiento x;
	@OneToOne
	@JoinColumn(name = "pasaje_id", referencedColumnName = "idPasaje")
	private Pasaje pasaje;

	public Ticket(long id, Cliente cliente, Asiento x, Pasaje pasaje) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.x = x;
		this.pasaje = pasaje;
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
	public Pasaje getPasaje() {
		return pasaje;
	}
	public void setPasaje(Pasaje pasaje) {
		this.pasaje = pasaje;
	}

	


}
