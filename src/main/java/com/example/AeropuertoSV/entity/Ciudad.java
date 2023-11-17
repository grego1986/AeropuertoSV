package com.example.AeropuertoSV.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudades")
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
	private List<Vuelo> vuelosDestino;
	@OneToMany(mappedBy = "origen", cascade = CascadeType.ALL)
	private List<Vuelo> vuelosOrigen;
	
	public Ciudad() {
		super();
	}


	public Ciudad(String nombre, List<Vuelo> vuelosDestino, List<Vuelo> vuelosOrigen) {
		super();
		this.nombre = nombre;
		this.vuelosDestino = vuelosDestino;
		this.vuelosOrigen = vuelosOrigen;
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

	

	public List<Vuelo> getVuelosDestino() {
		return vuelosDestino;
	}


	public void setVuelosDestino(List<Vuelo> vuelosDestino) {
		this.vuelosDestino = vuelosDestino;
	}


	public List<Vuelo> getVuelosOrigen() {
		return vuelosOrigen;
	}


	public void setVuelosOrigen(List<Vuelo> vuelosOrigen) {
		this.vuelosOrigen = vuelosOrigen;
	}


	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + "]";
	}
	
	
	
}
