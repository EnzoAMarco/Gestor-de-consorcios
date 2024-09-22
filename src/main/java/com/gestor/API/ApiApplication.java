package com.gestor.API;

import com.gestor.API.models.Edificio;
import com.gestor.API.persistencia.DAOs.EdificioDAO;
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
	EdificioDAO edificioDAO ;

	@Override
	public void run(String... args) throws Exception {

		List<Edificio> edificios = edificioDAO.getAllEdificios();

		for (Edificio edificio : edificios) {
			System.out.println(edificio.toString());
		}

	}
}
