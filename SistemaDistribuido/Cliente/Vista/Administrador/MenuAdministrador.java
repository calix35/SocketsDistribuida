package Vista.Administrador;

import java.util.Scanner;

public class MenuAdministrador{

    private Scanner sc;
    private int opcion;

    public MenuAdministrador(Scanner sc){        
        this.sc =  sc;
    }

    public int getOpcion(){
        return this.opcion;
    }

    public void show(){
        System.out.println("1) Alta de Usuarios");
        System.out.println("2) Baja de Usuarios");
        System.out.println("3) Cerrar Sesion");
        System.out.print("Opcion: ");
        opcion =  sc.nextInt();
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }

}