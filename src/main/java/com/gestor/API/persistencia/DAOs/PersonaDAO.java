package com.gestor.API.persistencia.DAOs;

import com.gestor.API.persistencia.repositories.PersonaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDAO {
    PersonaRepository personaRepository;

    public PersonaDAO(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
}
