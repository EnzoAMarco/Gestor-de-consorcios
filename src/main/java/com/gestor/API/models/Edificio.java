package com.gestor.API.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gestor.API.DTOs.EdificioDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "edificios")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = false, length = 100)
	private String direccion;

	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Unidad> unidades;

	public Edificio() {}

	public Edificio(int codigo, String nombre, String direccion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		unidades = new ArrayList<Unidad>();
	}



	@Override
	public String toString() {
		return "Edificio{" +
				"codigo=" + codigo +
				", nombre='" + nombre + '\'' +
				", direccion='" + direccion + '\'' +
				", unidades=" + unidades +
				'}';
	}

	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}
	
	public Set<Persona> habilitados(){
		Set<Persona> habilitados = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				habilitados.add(p);
			List<Persona> inquilinos = unidad.getInquilinos();
			for(Persona p : inquilinos)
				habilitados.add(p);
		}
		return habilitados;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public Set<Persona> duenios() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				duenios.add(p);
		}
		return resultado;
	}

	public Set<Persona> habitantes() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			if(unidad.estaHabitado()) {
				List<Persona> inquilinos = unidad.getInquilinos();
				if(inquilinos.size() > 0) 
					for(Persona p : inquilinos)
						resultado.add(p);
				else {
					List<Persona> duenios = unidad.getDuenios();
					for(Persona p : duenios)
						resultado.add(p);
				}
			}
		}
		return resultado;
	}

	public EdificioDTO toView() {
		return new EdificioDTO(codigo, nombre, direccion);
	}
}
