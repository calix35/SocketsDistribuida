package Vista.Ventas;

import java.util.Scanner;
import DataObjects.Producto;

public class AltaProductos{
    private Producto producto;

    public Producto getProducto(){
        return this.producto;
    }

    public AltaProductos(Scanner sc){
        String id, nombre;
        int existencias;
        double costo;
        System.out.print("Id: ");        
        id = sc.nextLine();
        id = sc.nextLine();
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Existencias: ");
        existencias = sc.nextInt();
        System.out.print("Costo: ");
        costo = sc.nextDouble();
        this.producto = new Producto(id, nombre, existencias, costo);
    }
}