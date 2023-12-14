package com.example.AeropuertoSV.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.AeropuertoSV.entity.Vuelo;
import com.example.AeropuertoSV.service.VueloService;

public class Validaciones {

	@Autowired
	private VueloService vuelo;
	public Validaciones() {
		super();
	}


	
	public static boolean esNumero(String str) {
        	
		try {
           
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
		
		
    }
	
	public boolean vacio (String nv) {
		boolean resultado = false;
		if (nv =="") {
			resultado = true;
		}
		return resultado;
	}
	
	
	public boolean OrigenDestinoVacio (RegistroVueloForm rv) {
		boolean v = false;
		if ((rv.getOrigen() == null) || (rv.getDestino() == null)) {
			v=true;
			throw new IllegalArgumentException("La ciudad de origen o Ciudad de destino no puede ser nulos aca.");
		} 
		return v;
	}
	
	public boolean avionVacio(RegistroVueloForm rv) {
		boolean v = false;
		if (rv.getAvionAsignado()== null) {
			v=true;
			throw new IllegalArgumentException("Seleccione un avion para el vuelo.");
		
		}
		return v;
	}
}
