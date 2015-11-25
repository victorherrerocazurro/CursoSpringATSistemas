package com.servicoparejas.controlador;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.parejas.modelo.entidades.Persona;

@RestController
@RequestMapping(path="/personas")
public class ServicioRestPersona {

		@RequestMapping(path="/{id}", 
				method=RequestMethod.GET, 
				produces=MediaType.APPLICATION_JSON_VALUE)
		//@ResponseBody
		public Persona getPersona(@PathVariable("id") int id){
			return new Persona();
		}
		
		@RequestMapping(method=RequestMethod.GET)
		//@ResponseBody
		public List<Persona> getPersona(){
			return null;
		}
		
		@RequestMapping(method=RequestMethod.POST)
		//@ResponseBody
		public Persona postPersona(){
			return new Persona();
		}
		
		@RequestMapping(method=RequestMethod.PUT)
		//@ResponseBody
		public Persona putPersona(){
			return new Persona();
		}
		
		@RequestMapping(method=RequestMethod.DELETE)
		//@ResponseBody
		public Persona deletePersona(){
			return new Persona();
		}
	
}
