package com.servicoparejas.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.parejas.modelo.entidades.Persona;

@RestController
//@Controller
@RequestMapping(path="/personas")
public class ServicioRestPersona {

		@RequestMapping(path="/{id}", 
				method=RequestMethod.GET, 
				produces=MediaType.APPLICATION_JSON_VALUE)
//		@ResponseBody
		public Persona getPersona(@PathVariable("id") int id){
			return new Persona();
		}
		
		@RequestMapping(method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
//		@ResponseBody
		public List<Persona> getPersona(){
			List<Persona> resultado = new ArrayList<>();
			
			resultado.add(new Persona());
			resultado.add(new Persona());
			resultado.add(new Persona());
			
			return resultado ;
		}
		
		@RequestMapping(method=RequestMethod.POST,
				produces=MediaType.APPLICATION_JSON_VALUE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
//		@ResponseBody
		public Persona postPersona(@RequestBody Persona p){
			p.setId(12);
			return p;
		}
		
		@RequestMapping(method=RequestMethod.PUT,
				produces=MediaType.APPLICATION_JSON_VALUE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
//		@ResponseBody
		public Persona putPersona(@RequestBody Persona p){
			return new Persona();
		}
		
		@RequestMapping(path="/{id}", 
				method=RequestMethod.DELETE,
				produces=MediaType.APPLICATION_JSON_VALUE)
//		@ResponseBody
		public Persona deletePersona(@PathVariable("id") int id){
			return new Persona();
		}
	
}
