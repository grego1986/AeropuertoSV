package com.example.AeropuertoSV.service;


import com.example.AeropuertoSV.entity.Ticket;


public interface ITicketService {
	public void cargarTicket(Ticket ticket);
	public void eliminarTicket(Ticket ticket);
    public Ticket buscarTicket(Long id);
	public void emitirTicket(Ticket ticket);

}
