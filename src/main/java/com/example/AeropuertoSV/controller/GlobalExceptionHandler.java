package com.example.AeropuertoSV.controller;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e, Model model) {
        // Aquí puedes agregar información personalizada de error al modelo
        model.addAttribute("error", e.getMessage());
        return "error"; // Puede ser el nombre de una vista Thymeleaf o FreeMarker
    }
}