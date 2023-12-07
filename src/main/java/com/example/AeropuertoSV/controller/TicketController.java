package com.example.AeropuertoSV.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AeropuertoSV.entity.Asiento;
import com.example.AeropuertoSV.entity.Cliente;
import com.example.AeropuertoSV.entity.Ticket;
import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.service.AsientoService;
import com.example.AeropuertoSV.service.ClienteService;
import com.example.AeropuertoSV.service.TicketService;
import com.example.AeropuertoSV.service.VueloService;

@Controller
@RequestMapping("/generarTicket")
public class TicketController {
	@Autowired
	private TicketService ticketS;
	@Autowired
	private ClienteService clienteS;
	@Autowired
	private VueloService vueloS;
	@Autowired
	private AsientoService asientoS;

	@GetMapping
	public String show(@RequestParam Long dni, Model modelo) {
		formTicket FormTicket = new formTicket();
		// List<Vuelo> vuelos = vueloS.getAll();
		List<Vuelo> vuelos = new ArrayList<>();
		modelo.addAttribute("formTicket", FormTicket);
		// acá ya empiezo setteando el cliente.
		FormTicket.setC(clienteS.consultarCliente(dni));
		// modelo.addAllAttributes("vuelosDisponibles",
		// vueloS.vuelosConAsientosDisponibles());
		for (Vuelo s : vueloS.getAll()) {
			List<Asiento> asientos =new ArrayList<>();
			for(Asiento a :  asientoS.getAll()) {
				if(s.getAvionAsignado().equals(a.getAvion())&&a.isDisponible()) {
					asientos.add(a);
				}
			}
			if(!asientos.isEmpty()) {
				vuelos.add(s);
			}
		}
		// modelo.addAttribute("vuelos", vuelosDisponibles);
		modelo.addAttribute("vuelos", vuelos);
		System.out.println("Nolan");
		System.out.println("Número de vuelos disponibles: " + vuelos.size());

		return "/generarTicket";
	}

}