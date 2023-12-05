package com.example.AeropuertoSV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AeropuertoSV.entity.TasaNacional;
import com.example.AeropuertoSV.repository.ITasaNacionalRepository;

@Service
public class TasaNacionalService implements ITasaNacionalService{

	@Autowired
	private ITasaNacionalRepository tasarepo;
	
	@Override
	public void cargarTasa(TasaNacional tasa) {
		tasarepo.save(tasa);
	}

	@Override
	public void modificarTasa(TasaNacional tasa, Integer id) {
		if(tasarepo.existsById(id)) {
			tasa.setId(id);
			tasarepo.save(tasa);
		}
		
	}

	@Override
	public TasaNacional consultarTasa(Integer id) {
		 return tasarepo.findById(id).orElse(null);
	}

	
	
	
	
}
