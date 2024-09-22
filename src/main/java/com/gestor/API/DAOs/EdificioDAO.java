package com.gestor.API.DAOs;

import com.gestor.API.models.Edificio;
import com.gestor.API.repositories.EdificioRepository;

import java.util.List;

public class EdificioDAO {

    private static EdificioDAO instacia;

    private EdificioDAO() {}

    public static  EdificioDAO getInstacia(){
        if (instacia == null)
            instacia = new EdificioDAO();
        return instacia;
    }

    //Obtengo todos los edificios de la BD (es solo para probar)
    public List<Edificio> getAllEdificios(EdificioRepository edificioRepository){
        return edificioRepository.findAll();
    }
}
