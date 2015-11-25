package com.aplicacion.parejas.modelo.negocio;

import java.util.List;

import com.aplicacion.parejas.modelo.entidades.Persona;

public interface Servicio {

	public abstract List<Persona> busquedaAfines(Integer id);

	public abstract Persona busquedaIdeal(Integer id);

	public abstract void altaPersona(Persona p);

}