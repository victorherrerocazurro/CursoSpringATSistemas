package com.aplicacion.parejas.modelo.negocio;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import com.aplicacion.parejas.modelo.entidades.Persona;

public interface Servicio {
	@PreAuthorize("not #id == 1 and authentication.username == 'Victor' ")
	@PostFilter("not filterObject.nombre == authentication.username")
	public abstract List<Persona> busquedaAfines(Integer id);

	@PostAuthorize("returnObject.nombre == authentication.name")
	public abstract Persona busquedaIdeal(Integer id);

	@PreAuthorize("hasRole('ROLE_USER')")
	@Secured("ROLE_USER")
	@RolesAllowed("ROLE_USER")
	public abstract void altaPersona(Persona p);

}