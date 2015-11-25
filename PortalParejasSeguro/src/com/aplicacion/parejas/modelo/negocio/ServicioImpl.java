package com.aplicacion.parejas.modelo.negocio;

import java.util.LinkedList;
import java.util.List;

import com.aplicacion.parejas.modelo.entidades.Persona;

public class ServicioImpl implements Servicio {
	
	/* (non-Javadoc)
	 * @see com.aplicacion.parejas.modelo.negocio.Servicio#busquedaAfines(com.aplicacion.parejas.modelo.entidades.Persona)
	 */
	@Override
	public List<Persona> busquedaAfines(Integer id){
	
		List<Persona> afines = new LinkedList<Persona>();
		
		return afines;
	}
	
	/* (non-Javadoc)
	 * @see com.aplicacion.parejas.modelo.negocio.Servicio#busquedaIdeal(com.aplicacion.parejas.modelo.entidades.Persona)
	 */
	@Override
	public Persona busquedaIdeal(Integer id){
		
		return null;
	}

	@Override
	public void altaPersona(Persona p) {

	}
}
