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
import com.example.AeropuertoSV.entity.Pasaje;
import com.example.AeropuertoSV.entity.Ticket;
import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.service.AsientoService;
import com.example.AeropuertoSV.service.ClienteService;
import com.example.AeropuertoSV.service.PasajeService;
import com.example.AeropuertoSV.service.TicketService;
import com.example.AeropuertoSV.service.VueloService;


@Controller
//sirve para asignar webs al controlador y sus métodos
@RequestMapping("/generarTicket")
public class TicketController {
	//inyección de dependencias
	@Autowired
	private TicketService ticketS;
	@Autowired
	private ClienteService clienteS;
	@Autowired
	private VueloService vueloS;
	@Autowired
	private AsientoService asientoS;
	@Autowired
	private PasajeService pasajeS;
	//get->Traigo
	//GetMapping-> Mapearía lo que traigo de los parámetros
	@GetMapping
	public String show(Long dni, Model modelo) {
		formTicket FormTicket = new formTicket();
		modelo.addAttribute("formTicket", FormTicket);

		List<Vuelo> vuelosDisponibles = obtenerVuelosConAsientosDisponibles();
		modelo.addAttribute("vuelos", vuelosDisponibles);

		modelo.addAttribute("dni", dni);
		// FormTicket.setDniCliente(dni);
	
		if (dni != null) {
			FormTicket.setDniCliente(dni);
		}
		return "generarTicket";
	}
	//Esta es otra página
	@GetMapping("/AsientosDisponibles")
	public String mostrarAsientosDisponibles(formTicket FormTicket, Model modelo) {
		Vuelo vueloSeleccionado = vueloS.consultarVuelo(FormTicket.getnVuelo());
		List<Asiento> asientosDisponibles = obtenerAsientosDisponibles(vueloSeleccionado);
		modelo.addAttribute("vuelos", vueloSeleccionado);
		//System.out.println("Número de asientos disponibles: " + asientosDisponibles.size());
		modelo.addAttribute("asiento", asientosDisponibles);
		// modelo.addAttribute("dni", FormTicket.getDniCliente());
		//System.out.print("Running by: " + FormTicket.getDniCliente());
		if (FormTicket.getDniCliente() != null && FormTicket.getAsiendoI() != null && FormTicket.getnVuelo() != null) {
			try {
				Ticket nTicket = new Ticket();
				Pasaje nPasaje = new Pasaje();
				nTicket.setCliente(clienteS.consultarCliente(FormTicket.getDniCliente()));
				nTicket.setX(asientoS.consultarAsiento(FormTicket.getAsiendoI()));
				//
				nPasaje.setCliente(nTicket.getCliente());
				nPasaje.setVuelo(vueloSeleccionado);
				//
				pasajeS.cargarPasaje(nPasaje);
				nTicket.setPasaje(nPasaje);
				ticketS.cargarTicket(nTicket);

				asientoS.consultarAsiento(FormTicket.getAsiendoI()).setDisponible(false);
				asientoS.cargarAsientoe(asientoS.consultarAsiento(FormTicket.getAsiendoI()));
				Long id = nTicket.getId();
				return "redirect:/ImprimirTicket?ticket="+id;
				//return "redirect:/ImprimirTicket?ticket" + nTicket;
				//return "redirect:/ImprimirTicket";
			} catch (Exception e) {
				String msg ="El cliente ya tiene un ticket y/o pasaje";
				return "redirect:/ingresarUsuario?msg=" + msg;
				
			}

		}
		return "generarTicket";
	}

	// Método privado para obtener vuelos con asientos disponibles
	private List<Vuelo> obtenerVuelosConAsientosDisponibles() {
		List<Vuelo> vuelos = new ArrayList<>();
		for (Vuelo s : vueloS.getAll()) {
			List<Asiento> asientos = new ArrayList<>();
			for (Asiento a : asientoS.getAll()) {
				if (s.getAvionAsignado().equals(a.getAvion()) && a.isDisponible()) {
					asientos.add(a);
				}
			}
			if (!asientos.isEmpty()) {
				vuelos.add(s);
			}
		}
		return vuelos;
	}
	// Método privado para obtener asientos disponibles para un vuelo
	private List<Asiento> obtenerAsientosDisponibles(Vuelo vuelo) {
		List<Asiento> asientosDisponibles = new ArrayList<>();
		for (Asiento asiento : asientoS.getAll()) {
			if (asiento.getAvion().equals(vuelo.getAvionAsignado()) && asiento.isDisponible()) {
				asientosDisponibles.add(asiento);
			}
		}
		return asientosDisponibles;
	}
}
