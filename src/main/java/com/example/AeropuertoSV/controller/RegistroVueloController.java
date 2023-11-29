package com.example.AeropuertoSV.controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AeropuertoSV.entity.Avion;
import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Internacional;
import com.example.AeropuertoSV.entity.Nacional;
import com.example.AeropuertoSV.entity.Pasaje;
import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.service.AvionService;
import com.example.AeropuertoSV.service.CiudadService;
import com.example.AeropuertoSV.service.InternacionalService;
import com.example.AeropuertoSV.service.NacionalService;
import com.example.AeropuertoSV.service.PaisService;


@Controller
@RequestMapping("/registroVuelo.html") // archivo html que se va a mapear
public class RegistroVueloController {

	@Autowired
	private CiudadService ciudadServi;
	@Autowired
	private AvionService avionServi;
	@Autowired
	private NacionalService nacionalServi;
	@Autowired
	private InternacionalService internacionalServi;
	
	RegistroVueloForm form = new RegistroVueloForm();

	@GetMapping
	public String abrirRegistroVuelo(Model modelo) {

		
		modelo.addAttribute("formBean", form);
		modelo.addAttribute("nVuelo", form);
		modelo.addAttribute("fecha", form);
		modelo.addAttribute("hora", form);
		
		modelo.addAttribute("origen", form);
		
		modelo.addAttribute("destino", form);
		
		modelo.addAttribute("avionAsignado", form);
		return "registroVuelo.html";
	}

	
	@ModelAttribute("ciudadOrigen")
	public List<Ciudad> origen() {
		return ciudadServi.getAll();
	}
	

	@ModelAttribute("ciudadDetino")
	public List<Ciudad> destino() {
		return ciudadServi.getAll();
	}

	@ModelAttribute("aviones")
	public List<Avion> avion() {
		return avionServi.getAll();
	}
	
	

	@PostMapping
	public String registrar(@ModelAttribute("formBean") RegistroVueloForm registro, ModelMap modelo, @RequestParam String action) {
		
		System.out.println("aca estoy");
		
		if(action.equals("verificar")) {
			return "redirect:/vuelosRegistrados.html";
		}else if(action.equals("guardar")) {
		    cargar(registro);
			modelo.clear();

			return "redirect:/registroVuelo.html";
		}else /*if(action.equals("volver"))*/ {
			modelo.clear();
			return "redirect:/";
		}
		
	}
	
	
	public void cargar (RegistroVueloForm rvf) {
		Ciudad cOrigen = ciudadServi.consultarCiudad(rvf.getOrigen());
		Ciudad cDestino = ciudadServi.consultarCiudad(rvf.getDestino());
	
		if (cOrigen.getPais().equals(cDestino.getPais())) {
			Nacional nacional = new Nacional (0, 0);
			nacional.setnVuelo(rvf.getnVuelo());
			nacional.setFecha(rvf.getFecha());
			nacional.setHora(rvf.getHora());
			nacional.setOrigen(cOrigen);
			nacional.setDestino(cDestino);
			nacional.setAvionAsignado(avionServi.consultarAvion(rvf.getAvionAsignado()));
			nacional.setEstado("Normal");
			
			nacionalServi.cargarNacional(nacional);
			
		} else {
			Internacional internacional = new Internacional ();
			internacional.setnVuelo(rvf.getnVuelo());
			internacional.setFecha(rvf.getFecha());
			internacional.setHora(rvf.getHora());
			internacional.setOrigen(cOrigen);
			internacional.setDestino(cDestino);
			internacional.setAvionAsignado(avionServi.consultarAvion(rvf.getAvionAsignado()));
			internacional.setEstado("Normal");
			
			internacionalServi.cargarInternacional(internacional);
			
		}
	}
	

}
