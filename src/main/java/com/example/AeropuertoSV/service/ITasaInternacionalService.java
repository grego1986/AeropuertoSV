package com.example.AeropuertoSV.service;

import com.example.AeropuertoSV.entity.TasaInternacional;

public interface ITasaInternacionalService {

	
	public void cargarTasa(TasaInternacional tasa);
	public void modificarTasa(TasaInternacional tasa, Integer id);
	public TasaInternacional consultarTasa (Integer id);
	
}
