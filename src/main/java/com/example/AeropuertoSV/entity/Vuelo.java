package com.example.AeropuertoSV.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name ="vuelos")
public abstract class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVuelo;
	@Column(name = "nroVuelo")
	private String nVuelo;
	@Column(name = "fecha")
	private LocalDate fecha;
	@Column(name = "hora")
	private LocalTime hora;
	@Column(name = "origen")
	private String origen;
	@Column(name = "destino")
	private String destino;
	@OneToMany(mappedBy = "vuelo")
	private List<Pasaje> pasajes;
	@Column(name = "estado")
	private String estado;
	
	
	public Vuelo() {
		super();
	}


	public Vuelo(long idVuelo, String nVuelo, LocalDate fecha, LocalTime hora, String origen, String destino) {
		super();
		this.idVuelo = idVuelo;
		this.nVuelo = nVuelo;
		this.fecha = fecha;
		this.hora = hora;
		this.origen = origen;
		this.destino = destino;
		this.estado = "Normal";
	}


	public long getIdVuelo() {
		return idVuelo;
	}


	public void setIdVuelo(long idVuelo) {
		this.idVuelo = idVuelo;
	}


	public String getnVuelo() {
		return nVuelo;
	}


	public void setnVuelo(String nVuelo) {
		this.nVuelo = nVuelo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public List<Pasaje> getPasajes() {
		return pasajes;
	}


	public void setPasajes(List<Pasaje> pasajes) {
		this.pasajes = pasajes;
	}

	

	}
