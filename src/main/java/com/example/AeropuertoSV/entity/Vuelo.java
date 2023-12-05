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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vuelos")
public abstract class Vuelo {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long idVuelo;
	//@Column(name = "nroVuelo")
	private String nVuelo;
	@Column(name = "fecha")
	private LocalDate fecha;
	@Column(name = "hora")
	private LocalTime hora;
	@ManyToOne
	@JoinColumn(name = "ciudad_origen")
	private Ciudad origen;
	@ManyToOne
	@JoinColumn(name = "ciudad_destino")
	private Ciudad destino;
	@OneToMany(mappedBy = "vuelo")
	private List<Pasaje> pasajes;
	@Column(name = "estado")
	private String estado;
	@ManyToOne
	@JoinColumn(name = "avion_Asignado")
	private Avion avionAsignado;

	public Vuelo() {
	}

	public Vuelo(String nVuelo, LocalDate fecha, LocalTime hora, Ciudad origen, Ciudad destino,
			List<Pasaje> pasajes, String estado, Avion avion) {
		super();
		this.nVuelo = nVuelo;
		this.fecha = fecha;
		this.hora = hora;
		this.origen = origen;
		this.destino = destino;
		this.pasajes = pasajes;
		this.estado = estado;
		this.avionAsignado = avion;
	}

/*	public long getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(long idVuelo) {
		this.idVuelo = idVuelo;
	}*/

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

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/*public void setIdVuelo(Long idVuelo) {
		this.idVuelo = idVuelo;
	}*/

	public List<Pasaje> getPasajes() {
		return pasajes;
	}

	public void setPasajes(List<Pasaje> pasajes) {
		this.pasajes = pasajes;
	}

	public Avion getAvionAsignado() {
		return avionAsignado;
	}

	public void setAvionAsignado(Avion avionAsignado) {
		this.avionAsignado = avionAsignado;
	}

	@Override
	public abstract String toString();

	
}
