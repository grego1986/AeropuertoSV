package com.example.AeropuertoSV.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Internacional;
import com.example.AeropuertoSV.entity.Nacional;
import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.service.AsientoService;
import com.example.AeropuertoSV.service.CiudadService;
import com.example.AeropuertoSV.service.InternacionalService;
import com.example.AeropuertoSV.service.NacionalService;
import com.example.AeropuertoSV.service.VueloService;

@Controller
@RequestMapping("/vuelos")
public class VuelosController {

    @Autowired
    private VueloService vueloService;

    @Autowired
    private CiudadService ciudadService;
    
    @Autowired
    private NacionalService nacionalServi;
    
    @Autowired
    private InternacionalService internacionalServi;
    
    @Autowired
    private AsientoService asientoServi;

    @GetMapping
    public String showVuelosPage(Model model) {
        VueloForm form = new VueloForm();
        model.addAttribute("vueloForm", form);
        model.addAttribute("nVuelo", form);
        model.addAttribute("fecha", form);
        model.addAttribute("origen", form);
        model.addAttribute("destino", form);
        model.addAttribute("tipoVuelo", form);
        return "vuelos.html";

    }

    @ModelAttribute("ciudadOrigen")
	public List<Ciudad> origen() {
		return ciudadService.getAll();
	}
	

	@ModelAttribute("ciudadDestino")
	public List<Ciudad> destino() {
		return ciudadService.getAll();
	}

    @ModelAttribute("tipoVuelo")
    public List<String> getTipoVuelo() {
        return List.of("Internacional", "Nacional");
    }

    @PostMapping
    public String buscarVuelos(@ModelAttribute("vueloForm") VueloForm form, ModelMap model, @RequestParam String action) {
        System.out.println("Objeto VueloForm: " + form);

        List<GrillaConsulta> vuelos = new ArrayList<>();
        Ciudad origen = null;
        Ciudad Destino = null;
        String redirecionar = "";
                
        if (action.equals("buscar")) {
        	        	
        	if (form.getOrigen() != null) {
        		origen = ciudadService.consultarCiudad(form.getOrigen());
        	}
        	
        	if (form.getDestino() != null) {
        		Destino = ciudadService.consultarCiudad(form.getDestino());
        	}
        	
        	if (form.getTipoVuelo().equals("nacional")) {
        		
        		vuelos.addAll(listaConsultaNacional(nacionalServi.obtenerVuelosFiltrados(form.getFecha(), origen, Destino)));
        		
        	
        	} else if(form.getTipoVuelo().equals("internacional")) {
        		
        		vuelos.addAll(listaConsultaInternacional(internacionalServi.obtenerVuelosFiltrados(form.getFecha(), origen, Destino)));
            	
        	} else {
        		
        		 vuelos.addAll( listaConsulta(vueloService.obtenerVuelosFiltrados(form.getFecha(), origen, Destino)));
        
        	}
           
        	model.addAttribute("vuelos", vuelos);
        	
        	redirecionar = "/vuelos";
        }
        
        if (action.equals("volver")) {
			model.clear();
			redirecionar = "redirect:/";
		}
     
        return redirecionar;
    }

    public List<GrillaConsulta> listaConsulta (List<Vuelo> vuelos){
    	 List<GrillaConsulta> lista = new ArrayList<>();
    	 for (Vuelo v : vuelos) {
    	     GrillaConsulta gc = new GrillaConsulta ();
    	     gc.setFecha(v.getFecha());
    	     gc.setHora(v.getHora());
    	     gc.setnVuelo(v.getnVuelo());
    	     gc.setEstado(v.getEstado());
    	  
             if (v instanceof Nacional) {
             	  gc.setTipoVuelo("Nacional");
             } else if (v instanceof Internacional) {
        	     gc.setTipoVuelo("Internacional");
             }
             gc.setAsientos(asientoServi.contarAsientosDisponiblesPorAvion(v.getAvionAsignado().getId()));
             lista.add(gc);
         }
    	
    	return lista;
    	
    }
    
    public List<GrillaConsulta> listaConsultaNacional (List<Nacional> vuelos){
   	 List<GrillaConsulta> lista = new ArrayList<>();
   	 for (Vuelo v : vuelos) {
   	     GrillaConsulta gc = new GrillaConsulta ();
   	     gc.setFecha(v.getFecha());
   	     gc.setHora(v.getHora());
   	     gc.setnVuelo(v.getnVuelo());
   	     gc.setEstado(v.getEstado());
   	     gc.setTipoVuelo("Nacional");
         
   	     gc.setAsientos(asientoServi.contarAsientosDisponiblesPorAvion(v.getAvionAsignado().getId()));
         lista.add(gc);
        }
   	
   	return lista;
   	
   }
    
    public List<GrillaConsulta> listaConsultaInternacional (List<Internacional> vuelos){
      	 List<GrillaConsulta> lista = new ArrayList<>();
      	 for (Vuelo v : vuelos) {
      	  GrillaConsulta gc = new GrillaConsulta ();
      	     gc.setFecha(v.getFecha());
      	     gc.setHora(v.getHora());
      	     gc.setnVuelo(v.getnVuelo());
      	     gc.setEstado(v.getEstado());
      	     gc.setTipoVuelo("Internacional");
             gc.setAsientos(asientoServi.contarAsientosDisponiblesPorAvion(v.getAvionAsignado().getId()));
             lista.add(gc);
           }
      	
      	return lista;
      	
      }
    
}