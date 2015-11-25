package com.ejemplo.prueba.servicio.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.aplicacion.parejas.modelo.entidades.Persona;

public class TestPeticionGet {

	@Test
	public void test() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Persona persona = restTemplate.getForObject(
				"http://localhost:8080/ServicioRestParejas/personas/12", 
				Persona.class);
		
		System.out.println(persona);
	}

}
