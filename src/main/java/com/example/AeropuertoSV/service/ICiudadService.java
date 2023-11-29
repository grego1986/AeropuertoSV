package com.example.AeropuertoSV.service;

import java.util.List;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Pais;

public interface ICiudadService {
	
	public List<Ciudad> getAll();
	public void cargarCiudad(Ciudad ciudad);
	public void modificarCiudad(Ciudad ciudad, Integer id);
	public void eliminarCiudad(Ciudad ciudad);
	public Ciudad consultarCiudad (Integer id);
	public List<Ciudad> obtenerLocalidadesPorPais(Pais pais);

}
