package com.example.AeropuertoSV.controller;


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
import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.service.AvionService;
import com.example.AeropuertoSV.service.CiudadService;
import com.example.AeropuertoSV.service.InternacionalService;
import com.example.AeropuertoSV.service.NacionalService;
import com.example.AeropuertoSV.service.VueloService;



@Controller
@RequestMapping("/registroVuelo") // archivo html que se va a mapear
public class RegistroVueloController {

	@Autowired
	private CiudadService ciudadServi;
	@Autowired
	private AvionService avionServi;
	@Autowired
	private NacionalService nacionalServi;
	@Autowired
	private InternacionalService internacionalServi;
	@Autowired
	private VueloService vuelo;
	
	private Validaciones validar = new Validaciones();
	
	RegistroVueloForm form = new RegistroVueloForm();
	FormPrecio fprecio = new FormPrecio();

	@GetMapping
	public String abrirRegistroVuelo(Model modelo) {
	
		modelo.addAttribute("formBean", form);
		modelo.addAttribute("nVuelo", form);
		modelo.addAttribute("fecha", form);
		modelo.addAttribute("hora", form);
		modelo.addAttribute("origen", form);
		modelo.addAttribute("destino", form);
		modelo.addAttribute("avionAsignado", form);
		modelo.addAttribute("precio", form);
		
		return "registroVuelo";
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
	
	@ModelAttribute("existe")
	public String existe () {
		return form.getExiste();
	}
	
	@ModelAttribute("tipoVuelo")
	public String tipo () {
		return form.getTipoVuelo();
	}
	
	@ModelAttribute("moneda")
	public String moneda () {
		return form.getMoneda();
	}
	
	@PostMapping
	public String registrar(@ModelAttribute("formBean") RegistroVueloForm registro, ModelMap modelo, @RequestParam String action) {
		String redirecionar = null;
		
		if(action.equals("verificar")) {
		    	if (vuelo.consultarVuelo(registro.getnVuelo()) != null) {
		    		form.setExiste("El numero de vuelo ya existe.");
		    		modelo.replace("existe", form.getExiste());
		    		
		    	} else {
		    		
		    		form.setExiste("El numero de Vuelo se encuentra disponible.");
		    		modelo.replace("existe", form.getExiste());	    		
		    	}
		    	
		}
		
		if(action.equals("guardar")) {
			
			if (vuelo.consultarVuelo(registro.getnVuelo()) != null) {
	    		modelo.clear();
	    		
	    	    form.setExiste("El numero de vuelo ya existe.");
	    	    modelo.replace("existe", form.getExiste());
	    	    redirecionar = "registroVuelo";
	    	} else {
	    		cargar(registro);
			    modelo.clear();
	    	}
		   

			redirecionar = "redirect:/registroVuelo.html";
		}
		
		if(action.equals("volver")) {
			modelo.clear();
			redirecionar = "redirect:/";
		}
		
		if (action.equals("vueloTipo")) {
			modelo.replace("tipoVuelo", vuelo(registro));
			modelo.replace("moneda", moneda(registro));
		}
		
		return redirecionar;
	}
	
	
	
	public void cargar (RegistroVueloForm rvf) {
		Ciudad cOrigen = ciudadServi.consultarCiudad(rvf.getOrigen());
		Ciudad cDestino = ciudadServi.consultarCiudad(rvf.getDestino());
	
		if (cOrigen.getPais().equals(cDestino.getPais())) {
			Double precio = 0.0;
			    Nacional nacional = new Nacional ();
			    nacional.setnVuelo(rvf.getnVuelo());
			    nacional.setFecha(rvf.getFecha());
			    nacional.setHora(rvf.getHora());
			    nacional.setOrigen(cOrigen);
			    nacional.setDestino(cDestino);
			    nacional.setAvionAsignado(avionServi.consultarAvion(rvf.getAvionAsignado()));
			    nacional.setEstado("Normal");
			   
			    nacional.setPrecio(precio);
			
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
	
	
	public String vuelo (RegistroVueloForm rvf) {
		Ciudad cOrigen = ciudadServi.consultarCiudad(rvf.getOrigen());
		Ciudad cDestino = ciudadServi.consultarCiudad(rvf.getDestino());
		String tipo = null;
		
		if (cOrigen.getPais().equals(cDestino.getPais())) {
			tipo = "Vuelo Nacional";
		} else {
			tipo = "Vuelo Internacional";
		}
		
		return tipo;
	}
	
	

	public String moneda (RegistroVueloForm rvf) {
		Ciudad cOrigen = ciudadServi.consultarCiudad(rvf.getOrigen());
		Ciudad cDestino = ciudadServi.consultarCiudad(rvf.getDestino());
		String moneda = null;
		
		if (cOrigen.getPais().equals(cDestino.getPais())) {
			moneda = "AR$";
		} else {
			moneda = "U$S";
		}
		
		return moneda;
	}

	
	public static boolean esNumero(String str) {
        
		
		try {
           
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
		
		
    }
	
}
