package com.example.AeropuertoSV.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Vuelo;

public class VueloForm {

	private Integer origen;
	private Integer destino;
    private LocalDate fecha;
    private String tipoVuelo;
    private String nVuelo;
    private LocalTime hora;
    private String estado;
    private String idVuelo;
    private List<Vuelo> vuelos; 

    public VueloForm() {
        super();
    }

    Ciudad ciudad = new Ciudad();

    public String getnVuelo() {
        return nVuelo;
    }

    public void setnVuelo(String nVuelo) {
        this.nVuelo = nVuelo;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = LocalDate.parse(fecha);
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = LocalTime.parse(hora);
    }

    
    
    public Integer getOrigen() {
		return origen;
	}

	public void setOrigen(Integer origen) {
		this.origen = origen;
	}

	public Integer getDestino() {
		return destino;
	}

	public void setDestino(Integer destino) {
		this.destino = destino;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = "Activo";
    }

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
