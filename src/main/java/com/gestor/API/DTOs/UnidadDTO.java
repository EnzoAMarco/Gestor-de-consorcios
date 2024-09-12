package com.gestor.API.DTOs;

public class UnidadDTO {

	private int id;
	private String piso;
	private String numero;
	private boolean habitado;
	private EdificioDTO edificio;
	
	public UnidadDTO() {}

	public UnidadDTO(int id, String piso, String numero, boolean habitado, EdificioDTO edificio) {
		this.id = id;
		this.piso = piso;
		this.numero = numero;
		this.habitado = habitado;
		this.edificio = edificio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isHabitado() {
		return habitado;
	}

	public void setHabitado(boolean habitado) {
		this.habitado = habitado;
	}

	public EdificioDTO getEdificio() {
		return edificio;
	}

	public void setEdificio(EdificioDTO edificio) {
		this.edificio = edificio;
	}
	
	public String toString() {
		return piso + " " + numero;
	}
}
