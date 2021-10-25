package Vista.Ventas;


import DataObjects.Producto;

import java.util.ArrayList;

public class ListadoProductos{
    

    public void imprimirProductos(ArrayList<Producto> productos){
        for(int i=0; i<productos.size(); i++)
            System.out.println(productos.get(i));
      
    }

}