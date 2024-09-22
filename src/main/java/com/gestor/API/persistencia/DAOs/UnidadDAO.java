package com.gestor.API.persistencia.DAOs;

import com.gestor.API.persistencia.repositories.UnidadRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UnidadDAO {

    UnidadRepository unidadRepository;

    public UnidadDAO(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }
}
