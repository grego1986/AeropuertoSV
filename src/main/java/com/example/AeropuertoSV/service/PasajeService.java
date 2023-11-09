package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AeropuertoSV.entity.Pasaje;
import com.example.AeropuertoSV.repository.IPasajeRepository;

@Service
public class PasajeService implements IPasajeService {

	
	@Autowired
	private IPasajeRepository pasajeRepo;

	@Override
	public List<Pasaje> getAll() {
		return pasajeRepo.findAll();
	}

	@Override
	public void cargarPasaje(Pasaje pasaje) {
		pasajeRepo.save(pasaje);		
	}

	@Override
	public void modificarPasaje( @RequestBody Pasaje pasaje, @PathVariable Long id) {
		if (pasajeRepo.existsById(id)) {
            pasaje.setIdPasaje(id);
            pasajeRepo.save(pasaje);
        }
	}

	@Override
	public void eliminarPasaje(Pasaje pasaje) {
		pasajeRepo.delete(pasaje);		
	}

	@Override
	public Pasaje consultarPasaje(Long id) {
		return pasajeRepo.findById(id).orElse(null);
	}
	
	
}
