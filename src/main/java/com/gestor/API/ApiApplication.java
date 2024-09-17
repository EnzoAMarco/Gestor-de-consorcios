package com.gestor.API;

import com.gestor.API.models.Edificio;
import com.gestor.API.models.Persona;
import com.gestor.API.models.Unidad;
import com.gestor.API.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Autowired
	UnidadRepository unidadRepository;
	//PersonaRepository personaRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		List<Persona> personas = PersonaDAO.getInstacia().obtenerAllPersona(personaRepository);

		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
		*/

		List<Unidad> unidades = UnidadDAO.getInstacia().listaUnidades(unidadRepository);

		for (Unidad unidad : unidades) {
			System.out.println(unidad.toString());
		}
	}
}
