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
	public String showForm(@RequestParam String dni, Model model) {
		formVuelo fVuelo = new formVuelo();
		// Logic to retrieve customer data based on DNI
		Cliente cliente = clienteS.consultarCliente(Long.parseLong(dni));

		// Logic to retrieve available flights and seats
		List<Vuelo> vuelos = vueloS.getAll();
		model.addAttribute("dni", dni);
		model.addAttribute("formVuelo",fVuelo);
		// Add data to the model
		model.addAttribute("cliente", cliente);
		model.addAttribute("vuelos", vuelos);
		System.out.print(fVuelo.getId_vuelo());
		return "generarTicket";
	}

	@PostMapping("/mAsientosDisponibles")
	public String mostrarAsientosDisponibles(formVuelo fVuelo, Model model) {
		model.addAttribute("formVuelo", fVuelo);
		System.out.print(fVuelo.getId_vuelo());

		Vuelo vSeleccionado = vueloS.consultarVuelo(fVuelo.getId_vuelo());

		List<Asiento> asientosDisponibles = new ArrayList<>();
		for (Asiento asiento : asientoS.getAll()) {
			if (asiento.getAvion().equals(vSeleccionado.avionAsignado)) {
				if (asiento.isDisiponible()) {
					asientosDisponibles.add(asiento);
				}
			}
		}

		model.addAttribute("vueloSeleccionado", vSeleccionado);
		model.addAttribute("asientos", asientosDisponibles);
		System.out.print(vSeleccionado.toString());

		return "generarTicket";
	}
}
