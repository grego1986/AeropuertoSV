package com.example.AeropuertoSV.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TasaInternacional")
public class TasaInternacional {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "IVA")
	private double iva;
	@Column(name = "tasa")
	private double tasa;
	@Column(name = "dolar")
	private double dolar;
	@OneToMany(mappedBy = "tasa")
	private List<Internacional> internacional;
	
	public TasaInternacional() {
		super();
	}

	public TasaInternacional(double iva, double tasa, double dolar) {
		super();
		this.iva = iva;
		this.tasa = tasa;
		this.dolar = dolar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public double getDolar() {
		return dolar;
	}

	public void setDolar(double dolar) {
		this.dolar = dolar;
	}

	@Override
	public String toString() {
		return "TasaInternacional [id=" + id + ", iva=" + iva + ", tasa=" + tasa + ", dolar=" + dolar + "]";
	}
	
	
	
	
}
