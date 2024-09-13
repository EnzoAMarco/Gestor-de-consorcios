package com.gestor.API.models;

import com.gestor.API.DTOs.EdificioDTO;
import com.gestor.API.DTOs.UnidadDTO;
import com.gestor.API.exceptions.UnidadException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "unidades")
public class Unidad {

	@Id
	private Integer id;

	@Column (name = "piso")
	private String piso;

	@Column (name = "numero")
	private String numero;

	@Column (name = "habitado")
	private boolean habitado;

	@ManyToOne
	@JoinColumn (name = "Id")
	private Edificio edificio;

	//Hay que ver como hacer una tabla intermedia
	private List<Persona> duenios;

	//Debe ser una tabla intermedia de duenios e inquilinos
	private List<Persona> inquilinos;
	
	public Unidad(int id, String piso, String numero, Edificio edificio) {
		this.id = id;
		this.piso = piso;
		this.numero = numero;
		this.habitado = false;
		this.edificio = edificio;
		this.duenios = new ArrayList<Persona>();
		this.inquilinos = new ArrayList<Persona>();
	}

	public void transferir(Persona nuevoDuenio) {
		duenios = new ArrayList<Persona>();
		duenios.add(nuevoDuenio);
	}
	
	public void agregarDuenio(Persona duenio) {
		duenios.add(duenio);
	}
	
	public void alquilar(Persona inquilino) throws UnidadException {
		if(!this.habitado) {
			this.habitado = true;
			inquilinos = new ArrayList<Persona>();
			inquilinos.add(inquilino);
		}
		else
			throw new UnidadException("La unidad esta ocupada");
	}

	public void agregarInquilino(Persona inquilino) {
		inquilinos.add(inquilino);
	}
	
	public boolean estaHabitado() {
		return habitado;
	}
	
	public void liberar() {
		this.inquilinos = new ArrayList<Persona>();
		this.habitado = false;
	}
	
	public void habitar() throws UnidadException {
		if(this.habitado)
			throw new UnidadException("La unidad ya esta habitada");
		else
			this.habitado = true;
	}
	
	public int getId() {
		return id;
	}

	public String getPiso() {
		return piso;
	}

	public String getNumero() {
		return numero;
	}

	
	public Edificio getEdificio() {
		return edificio;
	}

	public List<Persona> getDuenios() {
		return duenios;
	}

	public List<Persona> getInquilinos() {
		return inquilinos;
	}

	public UnidadDTO toView() {
		EdificioDTO auxEdificio = edificio.toView();
		return new UnidadDTO(id, piso, numero, habitado, auxEdificio);
	}
}
