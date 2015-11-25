package com.portalparejas.controladores;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aplicacion.parejas.modelo.entidades.Persona;
import com.aplicacion.parejas.modelo.negocio.Servicio;

@Controller
@RequestMapping(value="/gestionpareja")
public class GestionParejaController {

	@Autowired
	private Servicio servicio;
	
	//http://localhost:8080/PortalParejas/gestionpareja/afines/12
	@RequestMapping(value="/afines/{id}")
	public String buscarAfines(@PathVariable("id") int id, Map<String, Object> modelo){
		
		busquedaAfines(modelo);
		return "afines-pdf";
		
	}
	
	//http://localhost:8080/PortalParejas/gestionpareja/afines?id=12
	@RequestMapping(value="/afines")
	public String buscarAfines2(@RequestParam("id") int id, Map<String, Object> modelo){
		
		busquedaAfines(modelo);
		
		return "afines";
	}
	
	private void busquedaAfines(Map<String, Object> modelo) {
		//Collection<Persona> resultado = servicio.buscarAfinesPorId(id);
		
		ArrayList<Persona> resultadoAfines = new ArrayList<>();
		
		resultadoAfines.add(new Persona(1, "Victor", "Herrero", 20, "Masculino", 1.85));
		
		//Forma de pasar el modelo a la vista
		modelo.put("afines", resultadoAfines);
	}
	
	//http://localhost:8080/PortalParejas/gestionpareja/ideal
	@RequestMapping(value="/ideal", method=RequestMethod.GET)
	public ModelAndView buscarIdeal(){
		
		ModelAndView resultado = new ModelAndView("ideal");
		
		resultado.getModel().put("ideal", new Persona(1, "Victor", "Herrero", 20, "Masculino", 1.85));
		
		return resultado;
	}
	
	@RequestMapping(value="/ideal", method=RequestMethod.POST)
	public ModelAndView buscarIdeal1(){
		return null;
	}
	
}
