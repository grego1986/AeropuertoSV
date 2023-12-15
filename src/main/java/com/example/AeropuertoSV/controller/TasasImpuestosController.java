package com.example.AeropuertoSV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AeropuertoSV.entity.TasaInternacional;
import com.example.AeropuertoSV.entity.TasaNacional;
import com.example.AeropuertoSV.service.TasaInternacionalService;
import com.example.AeropuertoSV.service.TasaNacionalService;


//agregar el boton volver
/*
if (action.equals("volver")) {
	modelo.clear();
	redirecionar = "redirect:/";
}
*/


@Controller
@RequestMapping("/tasas")
public class TasasImpuestosController {
	@Autowired
	private TasaNacionalService tasanS;
	@Autowired
	private TasaInternacionalService tasaiS;

	
	@GetMapping
	public String abrirTasas(Model modelo) {
		formTasas fTasas = new formTasas();
		modelo.addAttribute("formTasas",fTasas);
		return "tasas";
	}
	
	@ModelAttribute("tn")
	public Double existe() {
		TasaNacional a = tasanS.consultarTasa(1);
		return  a.getTasa();
	}
	
	@PostMapping
	public String cambiarTasas(formTasas fTasas, int iva,int tasa_nacional, int tasa_internacional, int cotizacion_dolar,Model modelo) {
		/*
		 * Setteo los atributos
		 * al formulario de tasas
		 * 
		 * */
		fTasas.setIva(iva);
		fTasas.setCotizacion_dolar(cotizacion_dolar);
		fTasas.setTasa_internacional(tasa_internacional);
		fTasas.setTasa_nacional(tasa_nacional);
		TasaInternacional tasaInter = new TasaInternacional();
		tasaInter.setDolar(cotizacion_dolar);
		
		//TasaNacional tasaNacional = new TasaNacional();
	//	tasaNacional.setIva(*fTasas.getIva());
		//tasaNacional.setPrecio(cotizacion_dolar);
		
		//tasanS.cargarTasa();
		return "tasas";
	}
	
	
}
