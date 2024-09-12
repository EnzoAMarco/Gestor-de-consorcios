package com.gestor.API.DTO;

import java.util.List;

import modelo.Edificio;
import modelo.Imagen;
import modelo.Persona;
import modelo.Unidad;

public class ReclamoView {

	private int numero;
	private PersonaView usuario;
	private EdificioView edificio;
	private String ubicaci�n;
	private String descripcion;
	private UnidadView unidad;
	private Estado estado;
	private List<ImagenView> imagenes;
}
