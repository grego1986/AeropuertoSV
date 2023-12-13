package com.example.AeropuertoSV.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Cliente;
import com.example.AeropuertoSV.entity.Ticket;
import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.service.TicketService;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Controller
@RequestMapping("/ImprimirTicket")
public class impTicketController{
	
	@Autowired
	private TicketService ticketS;
	
	@GetMapping
	public String imprimirDatos(@RequestParam(name = "ticket", required = false) Long id,Model modelo) {
		//System.out.println("LOADALSDOASDOADOA" +id);
		Ticket nTicket = ticketS.buscarTicket(id);
		Vuelo v = nTicket.getPasaje().getVuelo();
	    Cliente c = nTicket.getCliente();
	    modelo.addAttribute("cNombre", c.getNombre());
	    modelo.addAttribute("cApellido", c.getApellido());
	    modelo.addAttribute("Vuelo", v.getnVuelo());
	    modelo.addAttribute("Asiento", nTicket.getX().getId());
	    modelo.addAttribute("fecha",v.getFecha());
	    modelo.addAttribute("hora",v.getHora());
	    modelo.addAttribute("cOrigen", v.getOrigen().getNombre());
	    modelo.addAttribute("cDestino", v.getDestino().getNombre());
	    return "ImprimirTicket";
	    /*
	     * 	private LocalDate fecha;
	@Column(name = "hora")
	private LocalTime hora;
	@ManyToOne
	@JoinColumn(name = "ciudad_origen")
	private Ciudad origen;
	@ManyToOne
	@JoinColumn(name = "ciudad_destino")
	private Ciudad destino;*/
	}
}

