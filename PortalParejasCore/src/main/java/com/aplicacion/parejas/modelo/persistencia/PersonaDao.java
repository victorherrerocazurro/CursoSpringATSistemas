package com.aplicacion.parejas.modelo.persistencia;

import java.util.List;

import com.aplicacion.parejas.modelo.entidades.Persona;

public interface PersonaDao {
	public int add(Persona p);
	public int edit(Persona p);
	public int borrar(Persona p);
	public Persona consulta(int id);
	public List<Persona> consulta();
}
