package Utilerias;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import DataObjects.Usuario;

public class Table{

    String tableName;    

    public Table(String name){
        this.tableName = name;        
    }

    public void add(Object obj){
        try {
            FileInputStream file = null;
            boolean existe = true;
            try{
                file = new FileInputStream(tableName);
                file.close();
            }catch(FileNotFoundException e){
                existe = false;            
            }        
            FileOutputStream fileo = new FileOutputStream(tableName, true);
            ObjectOutputStream oos;
            if(existe)
                oos = new AppendObjectOutputStream(fileo);
            else
                oos = new ObjectOutputStream(fileo);
            oos.writeObject(obj);  
            oos.close(); 
            fileo.close();     
        } catch (Exception e) {
            //TODO: handle exception
        }       
    }

    public Object get(int index){
        Object obj = null;
        try {            
            FileInputStream file = null;
            ObjectInputStream ois = null;
            file = new FileInputStream(tableName);
            ois = new ObjectInputStream(file);
            int count = 0;
            while(count<=index){
                obj = ois.readObject();
                if(obj==null) 
                    break;
                count++;
            }
            ois.close();
            file.close();
        } catch (Exception e) {
            //TODO: handle exception
        }      
        return obj;
    }

    public int size(){
        int count = 0;
        try {
            FileInputStream file = null;
            ObjectInputStream ois = null;
            file = new FileInputStream(tableName);
            ois = new ObjectInputStream(file);            
            while(ois.readObject()!=null){            
                count++;
            }
            ois.close();
            file.close();   
        } catch (Exception e) {
            //TODO: handle exception
        } 
        return count;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Table usuarios = new Table("prueba.dat");
        /*usuarios.add(new Usuario("alan","1234","Alan Diaz",1));
        usuarios.add(new Usuario("alan","1234","Pedro",1));*/
        /*usuarios.add(new Usuario("alan","1234","Juan",1));
        usuarios.add(new Usuario("alan","1234","Raul",1));*/

        Usuario user = (Usuario)usuarios.get(3);
        System.out.println(user.getNombre());
        
        /*Usuario user = usuarios.get(1);
        System.out.println(user.getNombre());*/
    }
    
}