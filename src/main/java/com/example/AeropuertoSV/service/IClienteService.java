package com.example.AeropuertoSV.service;

import java.util.List;
import com.example.AeropuertoSV.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> getAll();
	public void cargarCliente(Cliente cliente);
	public void modificarCliente(Cliente cliente, Long id);
	public void eliminarCliente(Cliente cliente);
	public Cliente consultarCliente (Long id);
}
