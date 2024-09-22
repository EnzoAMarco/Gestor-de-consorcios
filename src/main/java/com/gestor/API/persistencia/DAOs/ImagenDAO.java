package com.gestor.API.persistencia.DAOs;

import com.gestor.API.persistencia.repositories.ImagenRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ImagenDAO {
    ImagenRepository imagenRepository;

    public ImagenDAO(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

}
