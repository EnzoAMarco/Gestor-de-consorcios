package com.gestor.API.models;

import com.gestor.API.DTOs.Estado;
import com.gestor.API.DTOs.TipoReclamo;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "reclamos")
public class Reclamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idreclamo")
	private int numero;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "documento")
	private Persona usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo")
	private Edificio edificio;

	@Column(name = "ubicacion")
	private String ubicacion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "identificador")
	private Unidad unidad;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tiporeclamo")
	private String tipoReclamo;

	@Column(name = "estado")
	private String estado;

	//@OneToMany(mappedBy = "reclamo", fetch = FetchType.EAGER)
	//private List<Imagen> imagenes;

	public Reclamo() {
	}

	public Reclamo(int numero, Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad, String tipoReclamo, String estado) {
		this.numero = numero;
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.tipoReclamo = tipoReclamo;
		this.estado = estado;
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
	//	return estado;}
	/*
	public List<Imagen> getImagenes(){
		return this.imagenes;
	}
	*/
	//public void cambiarEstado(Estado estado) {
	//	this.estado = estado;}

	public void save() {
		
	}
	
	public void update() {
		
	}

	@Override
	public String toString() {
		return " -> Numero:" + numero +
				", usuario:" + usuario.getDocumento() +
				", edificio:" + edificio.getCodigo() +
				", ubicacion: " + ubicacion +
				", unidad: " + unidad.getId() +
				", descripcion: " + descripcion +
				", estado: " + estado +
				", tipoReclamo: " + tipoReclamo ;
				//", imagenes: " + imagenes;
	}
}
