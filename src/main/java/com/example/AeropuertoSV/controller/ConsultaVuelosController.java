package com.example.AeropuertoSV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultaVuelosController {

	
	@RequestMapping("/vuelos")
	public String abrirVuelos() {
		return "vuelos";
	}
	
}
