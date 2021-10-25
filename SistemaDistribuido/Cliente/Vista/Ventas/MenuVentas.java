package Vista.Ventas;

import java.util.Scanner;

public class MenuVentas{

    private Scanner sc;
    private int opcion;

    public MenuVentas(Scanner sc){        
        this.sc =  sc;
    }

    public int getOpcion(){
        return this.opcion;
    }

    public void show(){
        System.out.println("1) Alta de Productos");
        System.out.println("2) Ventas");
        System.out.println("3) Lista de Productos");
        System.out.println("4) Cerrar Sesion");
        System.out.print("Opcion: ");
        opcion =  sc.nextInt();
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }

}