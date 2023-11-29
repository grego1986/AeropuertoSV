package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Pais;
import com.example.AeropuertoSV.repository.ICiudadRepository;

@Service
public class CiudadService implements ICiudadService {

	@Autowired
	private ICiudadRepository ciudadRepo;

	@Override
	public List<Ciudad> getAll() {
		return ciudadRepo.findAll();
	}

	@Override
	public void cargarCiudad(Ciudad ciudad) {
		ciudadRepo.save(ciudad);
	}

	@Override
	public void modificarCiudad(Ciudad ciudad, Integer id) {
		if (ciudadRepo.existsById(id)) {
			ciudad.setId(id);
			ciudadRepo.save(ciudad);
		}
	}

	@Override
	public void eliminarCiudad(Ciudad ciudad) {

		ciudadRepo.delete(ciudad);
	}

	@Override
	public Ciudad consultarCiudad(Integer id) {
		return ciudadRepo.findById(id).orElse(null);
	}

	@Override
	public List<Ciudad> obtenerLocalidadesPorPais(Pais pais) {
		return ciudadRepo.findByPais(pais);
	}

}
