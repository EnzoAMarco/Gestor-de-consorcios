package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Edificio;
import com.gestor.API.persistencia.repositories.EdificioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EdificioDAO {

    EdificioRepository edificioRepository;

    public EdificioDAO(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    //Obtengo todos los edificios de la BD (es solo para probar)
    public List<Edificio> obtenerTodoslEdificios() {
        return edificioRepository.findAll();
    }

    public Optional<Edificio> buscarPorCodigo(int id) {
        return edificioRepository.findById(id);
    }

}
