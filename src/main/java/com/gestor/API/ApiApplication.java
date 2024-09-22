package com.gestor.API;

import com.gestor.API.models.Edificio;
import com.gestor.API.models.Unidad;
import com.gestor.API.persistencia.DAOs.EdificioDAO;
import com.gestor.API.persistencia.DAOs.UnidadDAO;
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
	EdificioDAO edificioDAO;
	@Autowired
	UnidadDAO unidadDAO;

	@Override
	public void run(String... args) throws Exception {

//		List<Edificio> edificios = edificioDAO.getAllEdificios();
//		List<Unidad> unidades = unidadDAO.getAllUnidades();
//
//		for (Edificio edificio : edificios) {
//			System.out.println(edificio.toString());
//		}
//
//		for (Unidad unidad : unidades) {
//			System.out.println(unidad.toString());
//		}
	}
}
