package com.gestor.API.repositories;

public class ImagenDAO {

    private static ImagenDAO instacia;

    private ImagenDAO() {}

    public static  ImagenDAO getInstacia(){
        if (instacia == null)
            instacia = new ImagenDAO();
        return instacia;
    }
}
