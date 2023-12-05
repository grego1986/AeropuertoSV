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
	@Column(name = "precio")
	private double precio;
	@Column(name = "tasa")
	private double tasa;
	@Column(name = "IVA")
	private double iva;
	@OneToMany(mappedBy = "tasa")
	private List<Nacional> nacional;
	
	public TasaNacional(double precio, double tasa, double iva) {
		super();
		this.precio = precio;
		this.tasa = tasa;
		this.iva = iva;
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
	@Override
	public String toString() {
		return "TasaNacional [id=" + id + ", precio=" + precio + ", tasa=" + tasa + ", iva=" + iva + "]";
	}
	
	
}