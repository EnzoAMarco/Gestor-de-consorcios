package com.gestor.API.repositories;

import com.gestor.API.models.Reclamo;

import java.util.List;

public class ReclamoDAO {

    private static ReclamoDAO instacia;

    private ReclamoDAO() {}

    public static  ReclamoDAO getInstacia() {
        if (instacia == null)
            instacia = new ReclamoDAO();
        return instacia;
    }

    public List<Reclamo> getAllReclamos(ReclamoRepository reclamoRepository) {
        return  reclamoRepository.findAll();
    }

}
