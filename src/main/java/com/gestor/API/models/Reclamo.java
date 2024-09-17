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
	private int numero;

	@ManyToOne
	@JoinColumn(name = "documento")  // Especificamos @JoinColumn
	private Persona usuario;

	@ManyToOne
	@JoinColumn(name = "codigo")  // Especificamos @JoinColumn
	private Edificio edificio;

	@Column(name = "ubicacion")
	private String ubicacion;  // Si es un área común

	@ManyToOne
	@JoinColumn(name = "identificador")  // Aquí también usamos @JoinColumn
	private Unidad unidad;  // Si es una unidad

	@Column(name = "descripcion")
	private String descripcion;

	private Estado estado;

	@OneToMany(mappedBy = "reclamo",fetch = FetchType.LAZY)
	private List<Imagen> imagenes;

	public Reclamo() {
	}

	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = Estado.nuevo;
		imagenes = new ArrayList<Imagen>();
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

	public Estado getEstado() {
		return estado;}

	public List<Imagen> getImagenes(){
		return this.imagenes;
	}

	public void cambiarEstado(Estado estado) {
		this.estado = estado;}

	public void save() {
		
	}
	
	public void update() {
		
	}
}
