package com.aplicacion.parejas.modelo.negocio;

import java.util.LinkedList;
import java.util.List;

import com.aplicacion.parejas.modelo.entidades.Persona;
import com.aplicacion.parejas.modelo.persistencia.PersonaDao;

public class ServicioImpl implements Servicio {
	
	private PersonaDao dao;
	
	public ServicioImpl(PersonaDao dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see com.aplicacion.parejas.modelo.negocio.Servicio#busquedaAfines(com.aplicacion.parejas.modelo.entidades.Persona)
	 */
	@Override
	public List<Persona> busquedaAfines(Integer id){
		Persona target = dao.consulta(id);
		List<Persona> candidatos = dao.consulta();
		
		List<Persona> afines = new LinkedList<Persona>();
		
		for (Persona candidato : candidatos) {
			if(candidato.getSexo().equals(target.getSexo())){
				afines.add(candidato);
			}
		}
		
		return afines;
	}
	
	/* (non-Javadoc)
	 * @see com.aplicacion.parejas.modelo.negocio.Servicio#busquedaIdeal(com.aplicacion.parejas.modelo.entidades.Persona)
	 */
	@Override
	public Persona busquedaIdeal(Integer id){
		Persona target = dao.consulta(id);
		List<Persona> candidatos = dao.consulta();
		
		for (Persona candidato : candidatos) {
			if(candidato.getSexo().equals(target.getSexo())){
				return candidato;
			}
		}
		
		return null;
	}

	@Override
	public void altaPersona(Persona p) {
		dao.add(p);
	}
}
