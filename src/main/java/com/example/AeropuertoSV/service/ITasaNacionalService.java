package com.example.AeropuertoSV.service;

import com.example.AeropuertoSV.entity.TasaNacional;


public interface ITasaNacionalService {

	public void cargarTasa(TasaNacional tasa);
	public void modificarTasa(TasaNacional tasa, Integer id);
	public TasaNacional consultarTasa (Integer id);
	
}
