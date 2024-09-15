package com.gestor.API;

import com.gestor.API.models.Edificio;
import com.gestor.API.repositories.EdificioDAO;
import com.gestor.API.repositories.EdificioRepository;
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
	EdificioRepository edificioRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Edificio> edificios = EdificioDAO.getInstacia().getAllEdificios(edificioRepository);

		for (Edificio edificio : edificios) {
			System.out.println(edificio.toString());
		}

	}
}
