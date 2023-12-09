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
	
}
