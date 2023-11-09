package com.example.AeropuertoSV.service;

import java.util.List;
import com.example.AeropuertoSV.entity.Pasaporte;

public interface IPasaporteService {

	public List<Pasaporte> getAll();
	public void cargarPasaporte(Pasaporte pasaporte);
	public void modificarPasaporte(Pasaporte pasaporte, Long id);
	public void eliminarPasaporte(Pasaporte pasaporte);
	public Pasaporte consultarPasaporte (Long id);
	
}
