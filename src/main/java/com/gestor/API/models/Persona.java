package com.gestor.API.models;

import com.gestor.API.DTOs.PersonaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	private String documento;
	@Column(name = "nombre")
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
