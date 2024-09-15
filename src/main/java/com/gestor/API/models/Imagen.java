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

	@Column(nullable = false, length = 300)
	private String path;

	@Column(length = 10)
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "idReclamo", nullable = false)
	private Reclamo reclamo;
	
	public Imagen(String tipo) {
		this.tipo = tipo;
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
