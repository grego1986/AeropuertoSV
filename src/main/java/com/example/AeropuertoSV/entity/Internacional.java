package com.example.AeropuertoSV.entity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "internacionales")
@DiscriminatorValue ("internacional")
public class Internacional extends Vuelo {

	@Column(name = "precio")
	private double precio;
	@Column(name = "tasa")
	private double tasa;

}
