package com.example.AeropuertoSV.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AeropuertoSV.entity.Asiento;
import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Cliente;
import com.example.AeropuertoSV.entity.Ticket;
import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.repository.IClienteRepository;
import com.example.AeropuertoSV.repository.ITicketRepository;
import com.example.AeropuertoSV.repository.IVueloRepository;

@Service
public class TicketService implements ITicketService {
	@Autowired
	private ITicketRepository ticketRepo;
	private IClienteRepository ClienteRepo;
	private IVueloRepository VueloRepo;

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
		ticketSystem.append("De" + ticket.getPrecioPasaje().getVuelo().getOrigen() + "\\n" + ticket.getPrecioPasaje().getVuelo().getDestino());
		ticketSystem.append("Avion: " + ticket.getX().getAvion().getId());
		ticketSystem.append("Asiento " + ticket.getX().getId());
		System.out.print(ticketSystem);
	}

	@Override
	public boolean checkCliente(Cliente c) {
		if (ClienteRepo.existsById(c.getDni())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Asiento> getAsientos(Ciudad origen, Ciudad localidad) {
		List<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		// List<AsientoAvionId> aVu = new ArrayList();
		for (Vuelo n : VueloRepo.findAll()) {
			// Aca busco los vuelos por nombres, XD
			if ((n.getDestino().getNombre().equals(localidad.getNombre()))
					&& (n.getOrigen().getNombre().equals(origen.getNombre()))) {
				/*
				 * lo agrego a la lista de vuelos que coiciden si es de santa fe a bsas se
				 * agrega pop smoke
				 *
				 */
				vuelos.add(n);
			}
		}
		// tengo que buscar, los asientos DISPONIBLES de cada avión
		for (Vuelo k : vuelos) {
			if (k.getEstado() == "NORMAL" || k.getEstado() == "REPROGRAMADO") {
				for (Asiento m : k.getAvionAsignado().getAsientos()) {
					if (m.isDisiponible()) {
						asientosDisponibles.add(m);
					}
				}
			}
		}
		/*for (Asiento e : asientosDisponibles) {
		
		return e;
		}*/
		return asientosDisponibles;
	}

}
