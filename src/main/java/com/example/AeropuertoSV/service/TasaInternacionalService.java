package com.example.AeropuertoSV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AeropuertoSV.entity.TasaInternacional;
import com.example.AeropuertoSV.repository.ITasaInternacionalRepository;

@Service
public class TasaInternacionalService implements ITasaInternacionalService {
   
	@Autowired
	private ITasaInternacionalRepository tasarepo;
	
	
	@Override
	public void cargarTasa(TasaInternacional tasa) {
		tasarepo.save(tasa);
	}

	@Override
	public void modificarTasa(TasaInternacional tasa, Integer id) {
		if(tasarepo.existsById(id)) {
			tasa.setId(id);
			tasarepo.save(tasa);
		}
	}

	@Override
	public TasaInternacional consultarTasa(Integer id) {
		return tasarepo.findById(id).orElse(null);
	}

}
