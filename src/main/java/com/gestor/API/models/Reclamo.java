package com.gestor.API.models;

import com.gestor.API.DTOs.Estado;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "reclamos")
public class Reclamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReclamo;

	@ManyToOne
	@JoinColumn(name = "documento", nullable = false)  // Especificamos @JoinColumn
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "codigo", nullable = false)  // Especificamos @JoinColumn
	private Edificio edificio;

	@Column(length = 300)
	private String ubicacion;  // Si es un área común

	@ManyToOne
	@JoinColumn(name = "identificador", nullable = true)  // Aquí también usamos @JoinColumn
	private Unidad unidad;  // Si es una unidad

	@Column(nullable = false, length = 1000)
	private String descripcion;

	public Reclamo() {
	}

	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		//this.estado = Estado.nuevo;
		//imagenes = new ArrayList<Imagen>();
	}
	/*
	public void agregarImagen(String direccion, String tipo) {
		Imagen imagen = new Imagen(direccion, tipo);
		imagenes.add(imagen);
		imagen.save(numero);
	}
	*/

	public Edificio getEdificio() {
		return edificio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	//public Estado getEstado() {
		//return estado;}
	/*
	public List<Imagen> getImagenes(){
		return this.imagenes;
	}
	*/
	//public void cambiarEstado(Estado estado) {
		//this.estado = estado;}

	public void save() {
		
	}
	
	public void update() {
		
	}
}
