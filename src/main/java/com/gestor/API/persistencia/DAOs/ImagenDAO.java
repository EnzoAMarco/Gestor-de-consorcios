package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Imagen;
import com.gestor.API.persistencia.repositories.ImagenRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImagenDAO {
    ImagenRepository imagenRepository;

    public ImagenDAO(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public List<Imagen> obtenerImagenes(){
        return imagenRepository.findAll();
    }

}
