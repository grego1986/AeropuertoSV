package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AeropuertoSV.entity.Pasaporte;
import com.example.AeropuertoSV.repository.IPasaporteRepository;


@Service
public class PasaporteService implements IPasaporteService {
	
	@Autowired
	private IPasaporteRepository pasaporteRepo;

	@Override
	public List<Pasaporte> getAll() {
		return pasaporteRepo.findAll();
	}

	@Override
	public void cargarPasaporte(Pasaporte pasaporte) {
		pasaporteRepo.save(pasaporte);		
	}

	@Override
	public void modificarPasaporte(@RequestBody Pasaporte pasaporte, @PathVariable Long id) {
		if (pasaporteRepo.existsById(id)) {
            pasaporte.setId(id);
            pasaporteRepo.save(pasaporte);
        }		
	}

	@Override
	public void eliminarPasaporte(Pasaporte pasaporte) {
		pasaporteRepo.delete(pasaporte);
	}

	@Override
	public Pasaporte consultarPasaporte(Long id) {
		return pasaporteRepo.findById(id).orElse(null);
	}

}
