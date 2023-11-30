package com.example.AeropuertoSV.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
	@Column(name = "fila")
	private Integer fila;
	@Column(name = "columna")
	private Integer Columna;
	@OneToMany(mappedBy = "avion")
	private List<Asiento> asientos;
	@OneToMany(mappedBy = "avionAsignado", cascade = CascadeType.ALL)
	private List<Vuelo> vuelos;

	public Avion() {
		super();
	}

	public Avion(Long id, Integer fila, Integer columna, List<Asiento> asientos, List<Vuelo> vuelos) {
		super();
		this.id = id;
		this.fila = fila;
		Columna = columna;
		this.asientos = asientos;
		this.vuelos = vuelos;
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

	public List<Vuelo> getVuelos() {
		return vuelos;
	}
	public List<Asiento> cargarAsientos(){
		List<Asiento> AsientoMatriz = new ArrayList<>();
		for(int i=0; i<this.getFila().SIZE; i++) {
			for(int j=0; j<this.getColumna().SIZE; j++) {
				char f= (char) (j+97);
				//Asiento x = 
				AsientoMatriz.add(new Asiento(String.valueOf(f)+i,this,false));
			}
		}
		return AsientoMatriz;
	}
	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
