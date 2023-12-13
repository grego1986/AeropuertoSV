package com.example.AeropuertoSV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AeropuertoSV.service.ClienteService;

@Controller
@RequestMapping("/ingresarUsuario")
public class ClienteController {
	@Autowired
	private ClienteService clienteS;

	@GetMapping()
	public String ingresarUsuario(Model modelo,String msg) {
		modelo.addAttribute("formCliente", new formCliente());
		modelo.addAttribute("msg", msg);
		return "/ingresarUsuario";
	}

	@PostMapping("/validarDNI")
	public String buscarCliente(@RequestParam Long dni, Model modelo) {
		if (clienteS.consultarCliente(dni) != null) {
			return "redirect:/generarTicket?dni=" + dni;
		} else {
			//String msg = ;
			modelo.addAttribute("msg","El usuario con el DNI: " + dni + ", no existe");
			//return "redirect:/ingresarUsuario?msg=" + msg;
			return "/ingresarUsuario";
		}
	}
}