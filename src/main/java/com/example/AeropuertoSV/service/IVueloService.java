package com.example.AeropuertoSV.service;

import java.time.LocalDate;
import java.util.List;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Vuelo;


public interface IVueloService  {

	public List<Vuelo> getAll();
	public void cargarVuelo(Vuelo vuelo);
	public void modificarVuelo(Vuelo vuelo, String id);
	public void eliminarVuelo(Vuelo vuelo);
	public Vuelo consultarVuelo (String id);
	public List<Vuelo> obtenerVuelosFiltrados (LocalDate fecha, Ciudad ciudadOrigen, Ciudad ciudadDestino);
}
