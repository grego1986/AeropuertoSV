package com.example.AeropuertoSV.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.AeropuertoSV.entity.Ticket;


import com.example.AeropuertoSV.repository.ITicketRepository;


@Service
public class TicketService implements ITicketService {
	@Autowired
	private ITicketRepository ticketRepo;

	@Override
	public void cargarTicket(Ticket ticket) {
		ticketRepo.save(ticket);
	}

	@Override
	public void eliminarTicket(Ticket ticket) {
		ticketRepo.deleteById(ticket.getId());
	}

	@Override
	 public void emitirTicket(Ticket ticket) {
	 StringBuffer ticketSystem = new StringBuffer();
	 ticketSystem.append("Número de ticket" + ticket.getId());
	 ticketSystem.append("\\n Cliente:" + ticket.getCliente().getApellido() + ", " + ticket.getCliente().getNombre());
	 ticketSystem.append("\\n DNI: " + ticket.getCliente().getDni());
	 ticketSystem.append("De" + ticket.getPasaje().getVuelo().getOrigen() + "\\n" + ticket.getPasaje().getVuelo().getDestino());
	 ticketSystem.append("Avion: " + ticket.getX().getAvion().getId());
	 ticketSystem.append("Asiento " + ticket.getX().getId().getNumeroAsiento());
	 System.out.print(ticketSystem);
	 }

}
