package com.example.AeropuertoSV.service;

import java.util.List;

import com.example.AeropuertoSV.entity.Pais;

public interface IPaisService {


	public List<Pais> getAll();
	public void cargarPais(Pais pais);
	public void modificarPais(Pais pais, Integer id);
	public void eliminarPais(Pais pais);
	public Pais consultarPais (Integer id);
	
}
