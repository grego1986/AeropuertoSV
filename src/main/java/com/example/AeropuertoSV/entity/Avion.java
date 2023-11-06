package com.example.AeropuertoSV.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aviones")
public class Avion {

	@Id
	private Long id;
	@Column(name ="fila")
	private Integer fila;
	@Column(name = "columna")
	private Integer Columna;
	@OneToMany(mappedBy = "avion")
	private List<Asiento> asientos;
	

	public Avion() {
		super();
	}

	public Avion(long id, Integer fila, Integer columna, List<Asiento> asientos) {
		super();
		this.id = id;
		this.fila = fila;
		Columna = columna;
		this.asientos = asientos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public Integer getColumna() {
		return Columna;
	}

	public void setColumna(Integer columna) {
		Columna = columna;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}
	
	

}
