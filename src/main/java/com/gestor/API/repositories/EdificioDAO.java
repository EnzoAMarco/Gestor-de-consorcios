package com.gestor.API.repositories;

import com.gestor.API.models.Edificio;

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
