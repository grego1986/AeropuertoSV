package com.example.AeropuertoSV.service;

import java.time.LocalDate;
import java.util.List;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Internacional;

public interface IInternacionalService {

	
	public List<Internacional> getAll();
	public void cargarInternacional(Internacional internacional);
	public void modificarInternacional(Internacional internacional, String id);
	public void eliminarInternacional(Internacional internacional);
	public Internacional consultarInternacional (String id);
	public List<Internacional> obtenerVuelosFiltrados (LocalDate fecha, Ciudad ciudadOrigen, Ciudad ciudadDestino);
}
