package com.example.AeropuertoSV.entity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "internacionales")
@DiscriminatorValue ("internacional")
public class Internacional extends Vuelo {

	@Column(name = "precio")
	private double precio;
	@ManyToOne
	@JoinColumn(name = "id_Tasa")
	private TasaInternacional tasa;
	
	public Internacional() {
	}


	public Internacional(double precio, TasaInternacional tasa) {
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


	public TasaInternacional getTasa() {
		return tasa;
	}


	public void setTasa(TasaInternacional tasa) {
		this.tasa = tasa;
	}


	@Override
	public String toString() {
		return "Internacional";
	}
	
	

}
