package com.gestor.API.controllers;

import com.gestor.API.DTOs.*;
import com.gestor.API.exceptions.EdificioException;
import com.gestor.API.exceptions.PersonaException;
import com.gestor.API.exceptions.ReclamoException;
import com.gestor.API.exceptions.UnidadException;
import com.gestor.API.models.Edificio;
import com.gestor.API.models.Persona;
import com.gestor.API.models.Reclamo;
import com.gestor.API.models.Unidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Controlador {

	private static Controlador instancia;
	
	private Controlador() { }
	
	public static Controlador getInstancia() {
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
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
	
	public List<PersonaDTO> habilitadosPorEdificio(int codigo) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habilitados = edificio.habilitados();
		for(Persona persona : habilitados)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaDTO> dueniosPorEdificio(int codigo) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> duenios = edificio.duenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaDTO> habitantesPorEdificio(int codigo) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habitantes = edificio.duenios();
		for(Persona persona : habitantes)
			resultado.add(persona.toView());
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
	
	public void agregarPersona(String documento, String nombre) {
		Persona persona = new Persona(documento, nombre);
		persona.save();
	}
	
	public void eliminarPersona(String documento) throws PersonaException {
		Persona persona = buscarPersona(documento);
		persona.delete();
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
 
	public int agregarReclamo(
			int codigo,
			String piso,
			String numero,
			String documento,
			String ubicacion,
			String descripcion
	) throws EdificioException, UnidadException, PersonaException {
		Edificio edificio = buscarEdificio(codigo);
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		Reclamo reclamo = new Reclamo(persona, edificio, ubicacion, descripcion, unidad);
		reclamo.save();
		return reclamo.getNumero();
	}
	/*
	public void agregarImagenAReclamo(int numero, String direccion, String tipo) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.agregarImagen(direccion, tipo);
	}
	*/
	public void cambiarEstado(int numero, Estado estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		//reclamo.cambiarEstado(estado);
		reclamo.update();
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
