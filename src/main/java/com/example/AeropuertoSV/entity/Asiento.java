package com.example.AeropuertoSV.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "asientos_aviones")
public class Asiento {
	@Id
	@GeneratedValue(strategy = GenerationType.)
	private String id; 
	//@MapsId("avionId")
	
	@JoinColumn(name ="avion_id")
	@ManyToOne
	private Avion avion;
	@Column(name = "disponible")
	private boolean disponible;

	public Asiento() {
		super();
	}

	public Asiento(String id, Avion avion, boolean disponible) {
		super();
		this.id = id;
		this.avion = avion;
		this.disponible = disponible;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Asiento [id=" + id + ", avion=" + avion + ", disponible=" + disponible + "]";
	}

}