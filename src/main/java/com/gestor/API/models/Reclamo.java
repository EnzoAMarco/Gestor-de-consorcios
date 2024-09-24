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
	@Column(name="idreclamo")
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

	@Column(name = "tiporeclamo")
	private  String tipoReclamo;

	@Column(name="estado")
	private String estado;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "reclamo", fetch = FetchType.EAGER)
	private List<Imagen> imagenes;

	public Reclamo() {
	}

	public Reclamo(int numero, Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad, String estado) {
		this.numero=numero;
		this.usuario= usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = estado;
		imagenes = new ArrayList<Imagen>();
	}

	public void agregarImagen(String direccion, String tipo) {
		Imagen imagen = new Imagen(direccion, tipo);
		imagenes.add(imagen);
		//imagen.save(numero);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public String getEstado() {
		return estado;}

	public List<Imagen> getImagenes(){
		return this.imagenes;
	}

	public void cambiarEstado(String estado) {
		this.estado = estado;}

	public void save() {
		
	}
	
	public void update() {
		
	}

	@Override
	public String toString() {
		return "Reclamo{" +
				"numero=" + numero +
				", usuario=" + usuario +
				", edificio=" + edificio +
				", ubicacion='" + ubicacion + '\'' +
				", unidad=" + unidad +
				", tipoReclamo='" + tipoReclamo + '\'' +
				", estado='" + estado + '\'' +
				", descripcion='" + descripcion + '\'' +
				", imagenes=" + imagenes +
				'}';
	}
}
