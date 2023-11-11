package com.example.AeropuertoSV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TasasImpuestosController {

	
	@RequestMapping("/tasas")
	public String abrirTasas() {
		return "tasas";
	}
}
