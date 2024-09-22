package com.gestor.API.controllers;
import com.gestor.API.persistencia.DAOs.*;
import com.gestor.API.DTOs.*;
import com.gestor.API.exceptions.EdificioException;
import com.gestor.API.exceptions.PersonaException;
import com.gestor.API.exceptions.ReclamoException;
import com.gestor.API.exceptions.UnidadException;
import com.gestor.API.models.Edificio;
import com.gestor.API.models.Persona;
import com.gestor.API.models.Reclamo;
import com.gestor.API.models.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class Controlador {
	@Autowired
	private EdificioDAO edificioDAO;

	@Autowired
	private PersonaDAO personaDAO;

	@Autowired
	private ReclamoDAO reclamoDAO;

	public Controlador(EdificioDAO edificioDAO, PersonaDAO personaDAO, ReclamoDAO reclamoDAO) {
		this.edificioDAO = edificioDAO;
		this.personaDAO = personaDAO;
		this.reclamoDAO = reclamoDAO;
	}

	public List<EdificioDTO> getEdificios(){
		return null;
	}

	public List<UnidadDTO> getUnidadesPorEdificio(int codigo) throws EdificioException {
		List<UnidadDTO> resultado = new ArrayList<UnidadDTO>();
		Edificio edificio = buscarEdificio(codigo);
		List<Unidad> unidades = edificio.getUnidades();
		for(Unidad unidad : unidades)
			resultado.add(unidad.toView());
		return resultado;
	}

	public List<PersonaDTO> habitadoPorEdificio(int id) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Optional<Edificio> edificio = edificioDAO.buscarPorCodigo(id);
		if (edificio.isEmpty()){
			System.out.println("no se encontro el edificio");
		}
		else {
			Set<Persona> habitado = edificio.get().habitado();
			for (Persona persona : habitado)
				resultado.add(persona.toView());
		}
		return resultado;
	}

	public List<PersonaDTO> dueniosPorEdificio(int id) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Optional<Edificio> edificio = edificioDAO.buscarPorCodigo(id);
		if (edificio.isEmpty()){
			System.out.println("no se encontro el edificio");
		}
		else {
			Set<Persona> duenios = edificio.get().duenios();
			for(Persona persona : duenios)
				resultado.add(persona.toView());
		}
		return resultado;
	}

	public List<PersonaDTO> habitantesPorEdificio(int id) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Optional<Edificio> edificio = edificioDAO.buscarPorCodigo(id);
		if (edificio.isPresent()) {
			Set<Persona> habitantes = edificio.get().duenios();
			for (Persona persona : habitantes)
				resultado.add(persona.toView());
		}
		else {
			System.out.println("no se encontro el edificio");
		}

		return resultado;
	}

	public List<PersonaDTO> dueniosPorUnidad(int codigo, String piso, String numero) throws UnidadException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> duenios = unidad.getDuenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaDTO> inquilinosPorUnidad(int codigo, String piso, String numero) throws UnidadException {
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> inquilinos = unidad.getInquilinos();
		for(Persona persona : inquilinos)
			resultado.add(persona.toView());
		return resultado;
	}
	
	public void transferirUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.transferir(persona);
	}

	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);
	}

	public void alquilarUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);
	}

	public void agregarInquilinoUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarInquilino(persona);
	}

	public void liberarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.liberar();
	}
	
	public void habitarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.habitar();;
	}
	
	public void agregarPersona(String id, String nombre) {
		Optional<Persona> optionalPersona = personaDAO.buscarPorDocumento(id);
		if (optionalPersona.isEmpty()){
			Persona persona = new Persona(id, nombre);
			personaDAO.agregarPersona(persona);
		}
		else{
			System.out.println("La persona ya fue ingresada");
		}
	}
	
	public void eliminarPersona(String id) throws PersonaException {
		Optional<Persona> persona = personaDAO.buscarPorDocumento(id);
		personaDAO.deletePersona(id);
	}
	
	public List<ReclamoDTO> reclamosPorEdificio(int codigo){
		List<ReclamoDTO> resultado = new ArrayList<ReclamoDTO>();
		return resultado;
	}
	
	public List<ReclamoDTO> reclamosPorUnidad(int codigo, String piso, String numero) {
		List<ReclamoDTO> resultado = new ArrayList<ReclamoDTO>();
		return resultado;
	}
	
	public ReclamoDTO reclamosPorNumero(int numero) {
		ReclamoDTO resultado = null;
		return resultado;
	}
	
	public List<ReclamoDTO> reclamosPorPersona(String documento) {
		List<ReclamoDTO> resultado = new ArrayList<ReclamoDTO>();
		return resultado;
	}

	/*
	public void agregarImagenAReclamo(int numero, String direccion, String tipo) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.agregarImagen(direccion, tipo);
	}
	*/
	public void cambiarEstado(int id, Estado estado) throws ReclamoException {
		Optional<Reclamo> reclamo = reclamoDAO.buscarPorNumero(id);
		//reclamo.cambiarEstado(estado);
		//reclamo.
	}
	
	private Edificio buscarEdificio(int codigo) throws EdificioException {
		return null;
	}

	private Unidad buscarUnidad(int codigo, String piso, String numero) throws UnidadException{
		return null;
	}	
	
	private Persona buscarPersona(String documento) throws PersonaException {
		return null;
	}
	
	private Reclamo buscarReclamo(int numero) throws ReclamoException {
		return null;
	}
}
