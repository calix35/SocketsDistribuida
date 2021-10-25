package Modelo;

import java.util.ArrayList;

import DataObjects.Usuario;

public class ModeloUsuarios{

    //ArrayList - Crear una lista de objetos (object, int, float, ....)

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public ModeloUsuarios(){
        //Metodo add, agregar un elemento al final de la lista
        //Administrador
        usuarios.add(new Usuario("alan","1234","Alan Diaz", 1));
        usuarios.add(new Usuario("ventas","ventas","ventas", 2));
    }

    public Usuario login(String user, String pass){  
        //metodo size, darme el numero de elementos de la lista
        for(int i=0;i<usuarios.size();i++){//Recorriendo la lista
            //El metodo get, me da el elemento que esta en la posicion i de la lista
            if(usuarios.get(i).getUser().equals(user) && usuarios.get(i).getPass().equals(pass)){
                return usuarios.get(i);
            }
        }
        return null;
    }

    public void alta(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public boolean buscarUsuario(String user){
        for(int i=0; i<this.usuarios.size(); i++){
            if(this.usuarios.get(i).getUser().equals(user)){
                return true;
            }
        }
        return false;
    }

    public void eliminar(String user){
        for(int i=0; i<this.usuarios.size(); i++){
            if(this.usuarios.get(i).getUser().equals(user)){
                this.usuarios.remove(i);
                return;
            }
        }
        
    }

}