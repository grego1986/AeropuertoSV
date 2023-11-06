package com.example.AeropuertoSV.service;

import java.util.List;
import com.example.AeropuertoSV.entity.Avion;

public interface IAvionService {
	
	public List<Avion> getAll();
	public void cargarVuelo(Avion avion);
	public void modificarVuelo(Avion avion, Long id);
	public void eliminarVuelo(Avion avion);
	public Avion consultarVuelo (Long id);
}
