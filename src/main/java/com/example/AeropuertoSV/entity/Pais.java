package com.example.AeropuertoSV.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private List<Ciudad> ciudades;
	
	
	public Pais() {
		super();
	}


	public Pais(Integer id, String nombre, List<Ciudad> ciudades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudades = ciudades;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Ciudad> getCiudades() {
		return ciudades;
	}


	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}


	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
	

}
