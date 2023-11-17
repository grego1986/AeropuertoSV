package com.example.AeropuertoSV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vuelos")
public class ConsultaVuelosController {

	
	
	public String abrirVuelos() {
		return "vuelos";
	}
	
}
