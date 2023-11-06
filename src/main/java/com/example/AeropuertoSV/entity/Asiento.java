package com.example.AeropuertoSV.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "asientos_aviones")
public class Asiento {

	@EmbeddedId
	private AsientoAvionId id; 
	@MapsId("avionId")
	@JoinColumn(name ="avion_id")
	@ManyToOne
	private Avion avion;
	@Column(name = "disponible")
	private boolean disiponible;

	public Asiento() {
		super();
	}

	

	public Asiento(AsientoAvionId id, Avion avion, boolean disiponible) {
		super();
		this.id = id;
		this.avion = avion;
		this.disiponible = disiponible;
	}



	public AsientoAvionId getId() {
		return id;
	}



	public void setId(AsientoAvionId id) {
		this.id = id;
	}


	public Avion getAvion() {
		return avion;
	}



	public void setAvion(Avion avion) {
		this.avion = avion;
	}



	public boolean isDisiponible() {
		return disiponible;
	}



	public void setDisiponible(boolean disiponible) {
		this.disiponible = disiponible;
	}



	@Override
	public String toString() {
		return this.id.toString();
	}
	
	
}
