package com.example.AeropuertoSV.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nacionales")
@DiscriminatorValue ("nacional")
public class Nacional extends Vuelo {
	
	@Column(name = "precio")
	private double precio;
	@ManyToOne
	@JoinColumn(name = "id_Tasa")
	private TasaNacional tasa;
	
	public Nacional() {
		super();
	}

	public Nacional(double precio, TasaNacional tasa) {
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

	public TasaNacional getTasa() {
		return tasa;
	}

	public void setTasa(TasaNacional tasa) {
		this.tasa = tasa;
	}

	@Override
	public String toString() {
		return "Nacional";
	}
	
	

}
