package com.example.AeropuertoSV.service;

import java.util.List;
import com.example.AeropuertoSV.entity.Nacional;

public interface INacionalService {
	
	public List<Nacional> getAll();
	public void cargarNacional(Nacional nacional);
	public void modificarNacional(Nacional nacional, Long id);
	public void eliminarNacional(Nacional nacional);
	public Nacional consultarNacional (Long id);
}
