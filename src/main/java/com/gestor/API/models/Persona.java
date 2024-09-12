package com.gestor.API.models;

import com.gestor.API.DTOs.PersonaDTO;

public class Persona {

	private String documento;
	private String nombre;
	
	public Persona(String documento, String nombre) {
		this.documento = documento;
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public PersonaDTO toView() {
		return new PersonaDTO(documento, nombre);
	}

	public void save() {
		
	}

	public void delete() {
		
	}	
}
