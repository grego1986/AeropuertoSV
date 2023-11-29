package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AeropuertoSV.entity.Pais;
import com.example.AeropuertoSV.repository.IPaisRepository;

@Service
public class PaisService implements IPaisService {

	@Autowired
	private IPaisRepository paisRepo;
	
	@Override
	public List<Pais> getAll() {
		
		return paisRepo.findAll();
	}

	@Override
	public void cargarPais(Pais pais) {
		paisRepo.save(pais);
	}

	@Override
	public void modificarPais(Pais pais, Integer id) {
		if (paisRepo.existsById(id)) {
			pais.setId(id);
			paisRepo.save(pais);
		}
		
	}

	@Override
	public void eliminarPais(Pais pais) {
		paisRepo.delete(pais);		
	}

	@Override
	public Pais consultarPais(Integer id) {
		return paisRepo.findById(id).orElse(null);
	}

}
