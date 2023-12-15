package com.example.AeropuertoSV.service;

import java.time.LocalDate;
import java.util.List;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Nacional;

public interface INacionalService {
	
	public List<Nacional> getAll();
	public void cargarNacional(Nacional nacional);
	public void modificarNacional(Nacional nacional, String id);
	public void eliminarNacional(Nacional nacional);
	public Nacional consultarNacional (String id);
	public List<Nacional> obtenerVuelosFiltrados (LocalDate fecha, Ciudad ciudadOrigen, Ciudad ciudadDestino); 
}
