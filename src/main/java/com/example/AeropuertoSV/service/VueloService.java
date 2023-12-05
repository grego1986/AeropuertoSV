package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.repository.IVueloRepository;


@Service
public class VueloService implements IVueloService {

	@Autowired
	private IVueloRepository vueloRepo;
	
	
	
	@Override
	public List<Vuelo> getAll() {
		return vueloRepo.findAll();
	}

	@Override
	public void cargarVuelo(Vuelo vuelo) {
		vueloRepo.save(vuelo);
		
	}

	@Override
	public void modificarVuelo(@RequestBody Vuelo vuelo, @PathVariable String id ) {
		if (vueloRepo.existsById(id)) {
            vuelo.setnVuelo(id);
            vueloRepo.save(vuelo);
        } 	
	}

	@Override
	public void eliminarVuelo(Vuelo vuelo) {
		vueloRepo.delete(vuelo);
	}

	@Override
	public Vuelo consultarVuelo(@PathVariable String id) {
		return vueloRepo.findById(id).orElse(null);
	}

	
}
