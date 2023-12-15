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
@Table(name="TasaNacional")
public class TasaNacional {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	@Column(name = "tasa", nullable = false)
	private double tasa;
	@Column(name = "IVA",nullable = false)
	private double iva;
	@OneToMany(mappedBy = "tasa")
	private List<Nacional> nacional;
	
	public TasaNacional() {
		super();
	}
	
	public TasaNacional( double tasa, double iva) {
		super();
		this.tasa = tasa;
		this.iva = iva;
	}
	
	
	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
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
	
	
	public List<Nacional> getNacional() {
		return nacional;
	}

	public void setNacional(List<Nacional> nacional) {
		this.nacional = nacional;
	}

	@Override
	public String toString() {
		return "TasaNacional [id=" + id + ", tasa=" + tasa + ", iva=" + iva + "]";
	}
	
	
}
