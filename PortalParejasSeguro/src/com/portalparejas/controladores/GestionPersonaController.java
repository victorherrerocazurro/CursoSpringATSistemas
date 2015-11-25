package com.portalparejas.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.aplicacion.parejas.modelo.entidades.Persona;
import com.portalparejas.validadores.PersonaNombreValidador;

@Controller
@RequestMapping("/altaPersona")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class GestionPersonaController {

	@Autowired
	@Qualifier("utilleria")
	private UtilidadDeSession utilleria;
	
	public void setUtilleria(UtilidadDeSession utilleria) {
		this.utilleria = utilleria;
	}

	//Ampliar el numero de validaciones que se aplican a los objetos del Modelo
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new PersonaNombreValidador());
	}
	
	//Procesar el formulario
	@RequestMapping(method={RequestMethod.POST})
	public String altaPersona(@Valid @ModelAttribute("persona") Persona p, BindingResult result, HttpSession session, HttpServletRequest request){
		
		if (result.hasErrors()){	
			return "formularioAltaPersona";
		} else {	
			return "index";
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	//Inicializar los objetos que se representan en el formulario
	public String inicalizarAltaPersona(Model model){
		
		model.addAttribute("persona", new Persona());
		//model.addAttribute("listadoSexos",  new String[]{"Hombre","Mujer"});
		
		return "formularioAltaPersona";
	}
	
	/*@ModelAttribute("persona")
	public Persona initPersona(){
		return new Persona();
	}*/
	
	@ModelAttribute("listadoSexos")
	public String[] initListadoSexos(){
		return new String[]{"Hombre","Mujer"};
	}
	
}
