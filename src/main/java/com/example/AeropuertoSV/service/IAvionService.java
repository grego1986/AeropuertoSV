package com.example.AeropuertoSV.service;

import java.util.List;
import com.example.AeropuertoSV.entity.Avion;

public interface IAvionService {
	
	public List<Avion> getAll();
	public void cargarAvion(Avion avion);
	public void modificarAvion(Avion avion, Long id);
	public void eliminarAvion(Avion avion);
	public Avion consultarAvion (Long id);
}
