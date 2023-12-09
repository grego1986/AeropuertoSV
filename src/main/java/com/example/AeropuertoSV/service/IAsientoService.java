package com.example.AeropuertoSV.service;

import java.util.List;

import com.example.AeropuertoSV.entity.Asiento;


public interface IAsientoService {

	public List<Asiento> getAll();
	public void cargarAsientoe(Asiento asiento);
	public void modificarAsiento(Asiento asiento, String id);
	public void eliminarAsiento(Asiento asiento);
	public Asiento consultarAsiento (String id);
	public Long contarAsientosDisponiblesPorAvion(Long idAvion);
	
}
