package com.gestor.API.DAOs;

import com.gestor.API.models.Reclamo;
import com.gestor.API.repositories.ReclamoRepository;

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
