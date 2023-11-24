package com.example.AeropuertoSV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.AeropuertoSV")
public class AeropuertoSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeropuertoSvApplication.class, args);
	}

}
