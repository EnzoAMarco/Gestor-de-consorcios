package com.gestor.API;

import com.gestor.API.DTOs.PersonaDTO;
import com.gestor.API.controllers.Controlador;
import com.gestor.API.models.*;
import com.gestor.API.persistencia.DAOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Autowired
	EdificioDAO edificioDAO;
	@Autowired
	UnidadDAO unidadDAO;
	@Autowired
	PersonaDAO personaDAO;
	@Autowired
	ImagenDAO imagenDAO;
	@Autowired
	ReclamoDAO relamoDAO;
	@Autowired
	Controlador controlador;


	@Override
	public void run(String... args) throws Exception {

		/*-------------------------------------------EDIFICIO-------------------------------------------*/

		//----------Mostrar todas los edificios
		List<Edificio> edificios = edificioDAO.obtenerTodoslEdificios();
		for (Edificio edificio : edificios) {
			System.out.println(edificio.toString());
		}

		/*-------------------------------------------IMAGEN-------------------------------------------*/

//		List<Imagen> listaImagenes = imagenDAO.obtenerImagenes();
//		for (Imagen imagen : listaImagenes) {
//			System.out.println(imagen.toString());
//		}

		/*-------------------------------------------PERSONA-------------------------------------------*/

		//----------Mostrar todas las personas
//		List<Persona> personas = personaDAO.obtenerTodasPersonas();
//		for (Persona persona : personas) {
//			System.out.println(persona.toString());
//		}

		//----------Buscar persona por documento
//		Optional<Persona> personaPorID = personaDAO.obtenerPersona("DNI31740346");
//		System.out.println(personaPorID.toString());

		/*-------------------------------------------RECLAMO-------------------------------------------*/

		//----------Mostrar todas los reclamos
//		List<Reclamo> listaReclamos = relamoDAO.obtenerTodosReclamos();
//		for (Reclamo reclamo : listaReclamos) {
//			System.out.println(reclamo.toString());
//		}

		//----------Buscar reclamo por ID

//		Optional<Reclamo> reclamo = relamoDAO.obtenerReclamoPorId(1);
//		System.out.println(reclamo.toString());

		/*-------------------------------------------UNIDAD-------------------------------------------*/

		//----------Mostrar todas las personas
//		List<Unidad> unidades = unidadDAO.getAllUnidades();
//		for (Unidad unidad : unidades) {
//			System.out.println(unidad.toString());
//		}

		/*-------------------------------------------DTOs-------------------------------------------*/



	}



}
