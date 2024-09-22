package com.gestor.API.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table (name = "imagenes")
public class Imagen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;

	@Column(name = "path")
	private String direccion;

	@Column(name = "tipo")
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "idreclamo")
	private Reclamo reclamo;

	public Imagen(int numero, String direccion, String tipo, Reclamo reclamo) {
		this.numero = numero;
		this.direccion = direccion;
		this.tipo = tipo;
		this.reclamo = reclamo;
	}

	public Imagen() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void save(int numeroReclamo) {
		
	}

}
