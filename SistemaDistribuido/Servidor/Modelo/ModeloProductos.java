package Modelo;

import java.util.ArrayList;

import DataObjects.Producto;

public class ModeloProductos{


    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public ModeloProductos(){
        productos.add(new Producto("1","Lapiz",3,2.50));
        productos.add(new Producto("2","Pluma",3,3.50));
        productos.add(new Producto("3","Borrador",5,1.50));
    }

    public ArrayList<Producto> getProductos(){
        return this.productos;
    }

    public void alta(Producto producto){
        this.productos.add(producto);
    }

    public Producto buscarProducto(String id){
        for(int i=0; i<productos.size(); i++)
            if(productos.get(i).getId().equals(id))
                return productos.get(i);                    
        return null;
    }

    

}