package com.example.AeropuertoSV.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "nacionales")
@DiscriminatorValue ("nacional")
public class Nacional extends Vuelo {
	
	@Column(name = "precio")
	private double precio;
	@Column(name = "tasa")
	private double tasa;
	
	public Nacional() {
		super();
	}

	public Nacional(double precio, double tasa) {
		super();
		this.precio = precio;
		this.tasa = tasa;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	@Override
	public String toString() {
		return "Nacional [precio=" + precio + ", tasa=" + tasa + "]";
	}
	
	

}
