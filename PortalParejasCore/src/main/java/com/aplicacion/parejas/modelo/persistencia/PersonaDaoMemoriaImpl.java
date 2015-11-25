package com.aplicacion.parejas.modelo.persistencia;

import java.util.LinkedList;
import java.util.List;

import com.aplicacion.parejas.modelo.entidades.Persona;

public class PersonaDaoMemoriaImpl implements PersonaDao {

	@Override
	public int add(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrar(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Persona consulta(int id) {
		return new Persona(1, "Marcos", "Fernandez", 26, "Hombre", 1.65);
	}

	@Override
	public List<Persona> consulta() {
		
		LinkedList<Persona> resultado = new LinkedList<Persona>();
		
		resultado.add(new Persona(2, "Juan", "Rodriguez", 30, "Hombre", 1.75));
		resultado.add(new Persona(3, "Jaime", "Perez", 24, "Hombre", 1.80));
		resultado.add(new Persona(3, "Pedro", "Jimenez", 27, "Hombre", 1.85));
		
		return resultado;
	}

}
