package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AeropuertoSV.entity.Asiento;
import com.example.AeropuertoSV.repository.IAsientoRepository;

@Service
public class AsientoService implements IAsientoService{
	
	@Autowired
	private IAsientoRepository asientoRepo;

	@Override
	public List<Asiento> getAll() {
		
		return asientoRepo.findAll();
	}

	@Override
	public void cargarAsientoe(Asiento asiento) {
		
		asientoRepo.save(asiento);
	}

	@Override
	public void modificarAsiento(@RequestBody Asiento asiento, @PathVariable String id) {
		if (asientoRepo.existsById(id)) {
            asiento.setId(id);
            asientoRepo.save(asiento);
        }
		
	}

	@Override
	public void eliminarAsiento(Asiento asiento) {
		asientoRepo.delete(asiento);
		
	}

	@Override
	public Asiento consultarAsiento(String id) {
		return asientoRepo.findById(id).orElse(null);
	}

	@Override
	public Long contarAsientosDisponiblesPorAvion(Long idAvion) {
		return asientoRepo.contarAsientosDisponiblesPorAvion(idAvion);
	}

}
