package com.example.AeropuertoSV.service;

import java.util.List;

import com.example.AeropuertoSV.entity.Asiento;
import com.example.AeropuertoSV.entity.AsientoAvionId;

public interface IAsientoService {

	public List<Asiento> getAll();
	public void cargarAsientoe(Asiento asiento);
	public void modificarAsiento(Asiento asiento, AsientoAvionId id);
	public void eliminarAsiento(Asiento asiento);
	public Asiento consultarAsiento (AsientoAvionId id);
	
}
