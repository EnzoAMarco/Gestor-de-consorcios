package com.gestor.API.models;

import com.gestor.API.DTOs.Estado;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "reclamos")
public class Reclamo {
	@Id
	private Integer numero;

	@ManyToOne
	@JoinColumn(name="documento",referencedColumnName ="documento" )
	private Persona usuario;

	@ManyToOne
	@JoinColumn(name="codigo",referencedColumnName ="codigo" )
	private Edificio edificio;

	@Column(name = "ubicacion")
	private String ubicacion;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "identificador")
	private Unidad unidad;

	//no encuentro conexion en la base de datos
	//private Estado estado;

	//no encuentro conexion en la base de datos
	//@OneToMany
	//private List<Imagen> imagenes;
	
	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
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
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Persona getUsuario() {
		return usuario;
	}

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
