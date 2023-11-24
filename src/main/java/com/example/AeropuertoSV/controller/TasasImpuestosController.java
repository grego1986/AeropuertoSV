package com.example.AeropuertoSV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasas")
public class TasasImpuestosController {

	
	@GetMapping
	public String abrirTasas() {
		return "tasas";
	}
}
