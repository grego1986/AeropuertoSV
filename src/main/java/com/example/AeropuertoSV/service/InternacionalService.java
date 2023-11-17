package com.example.AeropuertoSV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.AeropuertoSV.entity.Internacional;
import com.example.AeropuertoSV.repository.IInternacionalRepository;

@Service
public class InternacionalService implements IInternacionalService {
	
	@Autowired
	private IInternacionalRepository internRepo;

	@Override
	public List<Internacional> getAll() {
		return internRepo.findAll();
	}

	@Override
	public void cargarInternacional(Internacional internacional) {
		internRepo.save(internacional);	
	}

	@Override
	public void modificarInternacional(@RequestBody Internacional internacional, @PathVariable Long id) {
		if (internRepo.existsById(id)) {
            internacional.setIdVuelo(id);
            internRepo.save(internacional);
        }
		
	}

	@Override
	public void eliminarInternacional(Internacional internacional) {
		internRepo.delete(internacional);		
	}

	@Override
	public Internacional consultarInternacional(Long id) {
		return internRepo.findById(id).orElse(null);
	}
	
	

}