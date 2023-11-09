package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.AeropuertoSV.entity.Avion;
import com.example.AeropuertoSV.repository.IAvionRepository;


@Service
public class AvionService implements IAvionService {

	@Autowired
	private IAvionRepository avionRepo;
	
	
	@Override
	public List<Avion> getAll() {
		return avionRepo.findAll();
	}

	@Override
	public void cargarAvion(Avion avion) {
		avionRepo.save(avion);
	}

	@Override
	public void modificarAvion(@RequestBody Avion avion, @PathVariable Long id) {
		if (avionRepo.existsById(id)) {
            avion.setId(id);
            avionRepo.save(avion);
        }		
	}

	@Override
	public void eliminarAvion(Avion avion) {
		avionRepo.delete(avion);
	}

	@Override
	public Avion consultarAvion(Long id) {
		return avionRepo.findById(id).orElse(null);
	}

}
