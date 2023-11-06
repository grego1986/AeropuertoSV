package com.example.AeropuertoSV.service;

import java.util.List;
import com.example.AeropuertoSV.entity.Vuelo;


public interface IVueloService  {

	public List<Vuelo> getAll();
	public void cargarVuelo(Vuelo vuelo);
	public void modificarVuelo(Vuelo vuelo, Long id);
	public void eliminarVuelo(Vuelo vuelo);
	public Vuelo consultarVuelo (Long id);
}
