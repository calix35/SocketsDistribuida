package Vista.Ventas;

import java.util.Scanner;
import DataObjects.Producto;

public class VentaProductos{
    
    private Scanner sc;

    public VentaProductos(Scanner sc){
        this.sc = sc;
    }

    public String getId(){
        System.out.print("Id Producto (-1 para salir): ");
        return sc.nextLine();
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }

}