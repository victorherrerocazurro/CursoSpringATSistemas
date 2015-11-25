package com.portalparejas.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aplicacion.parejas.modelo.entidades.Persona;

public class PersonaNombreValidador implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Persona.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

		Persona p = (Persona) arg0;
		
		if (p.getNombre().equals("Victor")){
			arg1.rejectValue("nombre", "persona.nombre.error", "El nombre no puede ser Victor");
		}

	}

}
