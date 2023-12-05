package com.example.AeropuertoSV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AeropuertoSV.service.PasajeService;

@Controller
@RequestMapping("/tasas")
public class TasasController{
	
	
	@Autowired
	private PasajeService pasaje_S;
	
	
	public String pasajeIVA(Model modelo){ 
     double iva;
     double precio;
     double precioFinal;
     
     precio=pasaje_S.consultarPasaje(null).getPrecioPasaje();
     iva= (precio * 21)/ 100;
	 precioFinal= precio + iva;
	return null;
		
	}
	
}


