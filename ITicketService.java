package com.example.AeropuertoSV.service;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Cliente;
import com.example.AeropuertoSV.entity.Ticket;

import java.util.List;

import com.example.AeropuertoSV.entity.Asiento;


public interface ITicketService {
	public void cargarTicket(Ticket ticket);
	public void eliminarTicket(Ticket ticket);
	public List<Asiento> getAsientos(Ciudad origen, Ciudad localidad);
	public void emitirTicket(Ticket ticket);
	public boolean checkCliente(Cliente c);
}
