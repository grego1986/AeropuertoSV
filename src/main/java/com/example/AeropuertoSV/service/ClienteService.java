package com.example.AeropuertoSV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AeropuertoSV.entity.Cliente;
import com.example.AeropuertoSV.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private IClienteRepository clienteRepo;

	@Override
	public List<Cliente> getAll() {
		return clienteRepo.findAll();
	}

	@Override
	public void cargarCliente(Cliente cliente) {
		clienteRepo.save(cliente);
	}

	@Override
	public void modificarCliente(@RequestBody Cliente cliente,@PathVariable Long id) {
		if (clienteRepo.existsById(id)) {
            cliente.setDni(id);
            clienteRepo.save(cliente);
        }
		
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		
		clienteRepo.delete(cliente);
	}

	@Override
	public Cliente consultarCliente(Long id) {
		
		return clienteRepo.findById(id).orElse(null);
	}

}
