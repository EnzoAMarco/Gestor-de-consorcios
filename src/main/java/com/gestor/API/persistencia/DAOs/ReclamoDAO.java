package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Persona;
import com.gestor.API.models.Reclamo;
import com.gestor.API.persistencia.repositories.ReclamoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReclamoDAO {

    ReclamoRepository reclamoRepository;

    public ReclamoDAO(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    public List<Reclamo> obtenerTodosReclamos() {
        return  reclamoRepository.findAll();
    }

    public Optional<Reclamo> obtenerReclamoPorId(int id) {
        return reclamoRepository.findById(id);
    }

}
