package Vista.Administrador;

import java.util.Scanner;

public class BajaUsuarios{
    private Scanner sc;
    private String user;

    public String getUsuario(){
        return this.user;
    }

    public BajaUsuarios(Scanner sc){
        this.sc =  sc;        
    }

    public void show(){
        System.out.print("User: ");
        user = sc.nextLine();
        user = sc.nextLine();
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }

}