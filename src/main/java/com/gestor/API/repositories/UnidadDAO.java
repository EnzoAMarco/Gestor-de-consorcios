package com.gestor.API.repositories;

import com.gestor.API.models.Unidad;

import java.util.List;

public class UnidadDAO {

    private static UnidadDAO instacia;

    private UnidadDAO() {}

    public static  UnidadDAO getInstacia(){
        if (instacia == null)
            instacia = new UnidadDAO();
        return instacia;
    }

    public List<Unidad> listaUnidades(UnidadRepository unidadRepository){
        return unidadRepository.findAll();
    }

}
