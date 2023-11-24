package com.example.AeropuertoSV.controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.AeropuertoSV.entity.Avion;
import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.service.AvionService;
import com.example.AeropuertoSV.service.CiudadService;


@Controller
@RequestMapping("/registroVuelo.html")//archivo html que se va a mapear
public class RegistroVueloController {
	
	@Autowired
	private CiudadService ciudadServi;
    @Autowired
    private AvionService avionServi;
	
	
	@GetMapping
	public String abrirRegistroVuelo(Model modelo) {
		/*
		  RegistroVuevoForm es una clase, que tiene como atributos tipo de datos primitivos
		  esta clase sirbe para el mapeo del html
		*/
		RegistroVueloForm form = new RegistroVueloForm ();
		
		//luego a la variable modelo del tipo Model se le agrega todos los atributos
		//de la clase anteriormente instaciada
		
		modelo.addAttribute("formBean", form);
		
		//despues se le agrega cada atributo de la clase como se muestra y cada uno de las palabras entre comillas dobles se 
		// los usa para capturar los datos (yo utilice los mismo nombre de los atributos de la clase Registro VueloForm)
		// ejemplo <input type="text" th:field="*{estado}" />
		
		modelo.addAttribute("nVuelo", form);
		modelo.addAttribute("fecha", form);
		modelo.addAttribute("hora", form);
		modelo.addAttribute("origen", form);
		modelo.addAttribute("destino", form);
		modelo.addAttribute("estado", form);
		modelo.addAttribute("avionAsignado", form);
		return "registroVuelo.html";//retorna la pagina
	}
	
	//estos tres metodos con sus anotaciones es para rellenar las listas desplegables.
	//@ModelAttribute("ciudadOrigen") lo que esta entre parentesis es la vinculacion para hacer el recorrido de la lista 
	//<option th:each="ciudad : ${ciudadOrigen}" th:value="${ciudad}" th:text="${ciudad.nombre}"></option>
	
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
	 
  
    
}
