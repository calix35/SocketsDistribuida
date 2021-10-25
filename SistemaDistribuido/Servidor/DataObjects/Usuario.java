package DataObjects;

import java.io.Serializable;

public class Usuario implements Serializable{
    private String user;
    private String pass;
    private String nombre;
    private int tipo;

    public String getUser(){
        return this.user;
    }

    public String getPass(){
        return this.pass;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getTipo(){
        return this.tipo;
    }

    public Usuario(String user, String pass, String nombre, int tipo){
        this.user = user;
        this.pass = pass;
        this.nombre =  nombre;
        this.tipo = tipo;
    }
}