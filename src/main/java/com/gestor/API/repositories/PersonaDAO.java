package com.gestor.API.repositories;

import com.gestor.API.models.Edificio;
import com.gestor.API.models.Persona;

import java.util.List;

public class PersonaDAO {

    private static PersonaDAO instacia;

    private PersonaDAO() {}

    public static  PersonaDAO getInstacia(){
        if (instacia == null)
            instacia = new PersonaDAO();
        return instacia;
    }

    public List<Persona> obtenerAllPersona(PersonaRepository personaRepository){

        return personaRepository.findAll();
    }
}
