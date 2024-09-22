package com.gestor.API.DAOs;

public class UnidadDAO {

    private static UnidadDAO instacia;

    private UnidadDAO() {}

    public static  UnidadDAO getInstacia(){
        if (instacia == null)
            instacia = new UnidadDAO();
        return instacia;
    }
}
