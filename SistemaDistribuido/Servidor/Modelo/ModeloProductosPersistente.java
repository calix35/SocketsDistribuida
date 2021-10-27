package Modelo;

import java.util.ArrayList;

import DataObjects.Producto;

public class ModeloProductos{


    //private ArrayList<Producto> productos = new ArrayList<Producto>();
    Table productos = new Table("productos.dat");

    public ModeloProductos(){
        productos.add(new Producto("1","Lapiz",3,2.50));
        productos.add(new Producto("2","Pluma",3,3.50));
        productos.add(new Producto("3","Borrador",5,1.50));
    }

    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> prod =  new ArrayList<Producto>();        
        for(int i=0; i<productos.size(); i++)
            prod.add((Producto)productos.get(i));
        return prod;
    }

    /*
        Servidor    ------------ Cliente
            LP      <-----------    5
            CP      ----------->    N



        SERVIDOR

        CP = productos.size()
        writeInt(CP)
        for(int i=0; i<productos.size(); i++){
            Producto p =  (Producto)productos.get(i);
            //Producto debera ser serializable
            writeObject(p)
            
            writeUTF(p.getNombre())
            writeUTF(p.getId())
            writeDouble(p.getPrecio())
            writeInt(p.getCantidad())
        }
            

        CLIENTE
        
        N =  readInt()
        for(int i=0;i<N;i++){

            (Producto)readObject()

            readUTF() ---> Nombre
            System.out.println(Nombre);
            readUTF() ---> ID
            System.out.println(ID)
            readDouble() --> Precio
            System.out.println(precio)
            readInt() ---> Cantidad
            System.out.println(Cantidad)
        }
        writeUTF
        writeInt
        writeDouble

        writeObject()

        Producto{
            Nombre, (String)
            ID,   (String)
            Precio,  (Double)
            Cantidad (int)
        }
    
    */

    public void alta(Producto producto){
        productos.add(producto);
    }

    public Producto buscarProducto(String id){
        for(int i=0; i<productos.size(); i++)
            if(((Producto)productos.get(i)).getId().equals(id))
                return productos.get(i);                    
        return null;
    }

    

}