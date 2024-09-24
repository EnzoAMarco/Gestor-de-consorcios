package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Imagen;
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

    public Optional<Reclamo> buscarPorNumero(int id){
        return reclamoRepository.findById(id);
    }
    public void save(Reclamo reclamo){
        reclamoRepository.save(reclamo);
    }
    public List<Reclamo> findAll(){
        return reclamoRepository.findAll();
    }

}
