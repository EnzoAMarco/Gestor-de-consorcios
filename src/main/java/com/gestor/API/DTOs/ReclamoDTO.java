package com.gestor.API.DTOs;

import java.util.List;

public class ReclamoDTO {

	private int numero;
	private PersonaDTO usuario;
	private EdificioDTO edificio;
	private String ubicacion;
	private String descripcion;
	private UnidadDTO unidad;
	private Estado estado;
	private List<ImagenDTO> imagenes;
}
