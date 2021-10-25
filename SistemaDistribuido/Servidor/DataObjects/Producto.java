package DataObjects;

public class Producto{

    private String id;
    private String nombre;
    private int existencias;
    private double costo;

    public String getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getCosto(){
        return this.costo;
    }

    public int getExistencias(){
        return this.existencias;
    }
    
    public void restarExistencias(){
        this.existencias--;
    }

    public Producto(String id, String nombre, int existencias, double costo){
        this.id = id;
        this.nombre = nombre;        
        this.existencias = existencias;
        this.costo = costo;
    }

    public String toString(){
        return this.id + "\t" + this.nombre + "\t" + this.existencias + "\t" + this.costo;
    }

}