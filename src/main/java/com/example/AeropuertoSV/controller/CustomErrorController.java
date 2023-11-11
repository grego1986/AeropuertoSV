package com.example.AeropuertoSV.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController {

    @RequestMapping("/custom-error")
    public String handleError() {
        // Aquí puedes personalizar la lógica para manejar errores
        return "error"; // Puede ser el nombre de una vista Thymeleaf o FreeMarker
    }
}

