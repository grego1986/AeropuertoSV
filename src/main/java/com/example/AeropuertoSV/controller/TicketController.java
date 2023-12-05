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
/*	@Autowired
	private TicketService ticketS;
	@Autowired
	private ClienteService clienteS;

	@Autowired
	private VueloService vueloS;

	@Autowired
	private AsientoService asientoS;

	@GetMapping
	public String show(@RequestParam String dni, Model model) {
		formVuelo fVuelo = new formVuelo();
		Cliente cliente = clienteS.consultarCliente(Long.parseLong(dni));
		model.addAttribute("dni", dni);
		model.addAttribute("formVuelo", fVuelo);
		model.addAttribute("cliente", cliente);
		model.addAttribute("vuelos", vueloS.vuelosConAsientosDisponibles());
		return "generarTicket";
	}

	@GetMapping("/seleccionarVuelo")
	public String seleccionarVuelo(@RequestParam String dni,formVuelo fVuelo, Model model) {
		Cliente cliente = clienteS.consultarCliente(Long.parseLong(dni));
		// Obtener el vuelo seleccionado
		Vuelo vueloSeleccionado = obtenerVueloSeleccionado(fVuelo.getId_vuelo());
		
		// Obtener la lista de asientos disponibles para el vuelo seleccionado
		List<Asiento> asientosDisponibles = obtenerAsientosDisponibles(vueloSeleccionado);

		// Agregar atributos al modelo
		model.addAttribute("dni", dni);
		model.addAttribute("cliente", cliente);
		model.addAttribute("vueloSeleccionado", vueloSeleccionado);
		model.addAttribute("asientos", asientosDisponibles);
		model.addAttribute("isInAsientosDisponiblesPage", true);

		return "generarTicket";
	}

	@GetMapping("/seleccionarAsiento")
	public String seleccionarAsiento(@RequestParam String dni, @ModelAttribute formVuelo fVuelo, Model model) {
		System.out.println("ID del vuelo: " + fVuelo.getId_vuelo()); // Agrega este log para verificar el ID del vuelo
		Vuelo vSeleccionado = vueloS.consultarVuelo(fVuelo.getId_vuelo());

		// Obtener la lista de asientos disponibles para el vuelo seleccionado
		List<Asiento> asientosDisponibles = obtenerAsientosDisponibles(vSeleccionado);

		// Agregar atributos al modelo
		model.addAttribute("dni", dni);
		model.addAttribute("vueloSeleccionado", vSeleccionado);
		model.addAttribute("asiento", asientosDisponibles);

		return "generarTicket";
	}
	@GetMapping("/printTicket")
	public String imprimirsalvar( @ModelAttribute Ticket ticket, String dni, Vuelo vSeleccionado, Model model) {
		// Agrega los datos al modelo
	    model.addAttribute("ticket", ticket);
	    model.addAttribute("cliente", clienteS.consultarCliente(Long.parseLong(dni)));
	    model.addAttribute("dni", dni); // Reemplaza con tu lógica real
	    model.addAttribute("vuelo", vSeleccionado);
	   // model.addAttribute("asiento", aSeleccionado);

	    return "ticketGenerado";
	}	
	// Método para obtener el vuelo seleccionado
	private Vuelo obtenerVueloSeleccionado(Long idVuelo) {
		return vueloS.consultarVuelo(idVuelo);
	}

	// Método para obtener la lista de asientos disponibles para un vuelo
	private List<Asiento> obtenerAsientosDisponibles(Vuelo vuelo) {
		List<Asiento> asientosDisponibles = new ArrayList<>();
		for (Asiento asiento : asientoS.getAll()) {
			if (asiento.getAvion().equals(vuelo.avionAsignado) && asiento.isDisponible()) {
				asientosDisponibles.add(asiento);
			}
		}
		return asientosDisponibles;
	}*/
}