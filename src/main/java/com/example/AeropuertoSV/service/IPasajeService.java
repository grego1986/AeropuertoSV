package com.example.AeropuertoSV.service;

import java.util.List;
import com.example.AeropuertoSV.entity.Pasaje;

public interface IPasajeService {
	
	public List<Pasaje> getAll();
	public void cargarPasaje(Pasaje pasaje);
	public void modificarPasaje(Pasaje pasaje, Long id);
	public void eliminarPasaje(Pasaje pasaje);
	public Pasaje consultarPasaje (Long id);
	
}
