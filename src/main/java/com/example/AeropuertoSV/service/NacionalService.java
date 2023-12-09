package com.example.AeropuertoSV.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Nacional;
import com.example.AeropuertoSV.repository.INacionalRepository;

@Service
public class NacionalService implements INacionalService {

	@Autowired
	private INacionalRepository nacionalRepo;

	
	@Override
	public List<Nacional> getAll() {
		return nacionalRepo.findAll();
	}

	@Override
	public void cargarNacional(Nacional nacional) {
		nacionalRepo.save(nacional);	
	}

	@Override
	public void modificarNacional( @RequestBody Nacional nacional,@PathVariable String id) {
		if (nacionalRepo.existsById(id)) {
            nacional.setnVuelo(id);
            nacionalRepo.save(nacional);
        }		
	}

	@Override
	public void eliminarNacional(Nacional nacional) {
		nacionalRepo.delete(nacional);		
	}

	@Override
	public Nacional consultarNacional(String id) {
		return nacionalRepo.findById(id).orElse(null);
	}

	@Override
	public List<Nacional> obtenerVuelosFiltrados(LocalDate fecha, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
		return nacionalRepo.buscarVuelosPorFechaYFiltros(fecha, ciudadOrigen, ciudadDestino);
	}
	
	
	
}
