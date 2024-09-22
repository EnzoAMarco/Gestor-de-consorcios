package com.gestor.API.DAOs;

public class PersonaDAO {

    private static PersonaDAO instacia;

    private PersonaDAO() {}

    public static  PersonaDAO getInstacia(){
        if (instacia == null)
            instacia = new PersonaDAO();
        return instacia;
    }
}
