package com.example.AeropuertoSV.service;

import java.util.List;

import com.example.AeropuertoSV.entity.Internacional;

public interface IInternacionalService {

	
	public List<Internacional> getAll();
	public void cargarInternacional(Internacional internacional);
	public void modificarInternacional(Internacional internacional, Long id);
	public void eliminarInternacional(Internacional internacional);
	public Internacional consultarInternacional (Long id);
}
