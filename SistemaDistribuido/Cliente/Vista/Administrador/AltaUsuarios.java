package Vista.Administrador;

import java.util.Scanner;


public class AltaUsuarios{
    private String nombre, user, pass;
    private int tipo;

    public String getNombre() { return nombre; }
    public String getUser() { return user; }
    public String getPass() { return pass; }
    public int getTipo() { return tipo; }

    public AltaUsuarios(Scanner sc){
        System.out.print("Nombre: ");        
        nombre = sc.nextLine();
        nombre = sc.nextLine();
        System.out.print("User: ");
        user = sc.nextLine();
        System.out.print("Pass: ");
        pass = sc.nextLine();
        System.out.print("Tipo: ");
        tipo = sc.nextInt();
        //this.usuario = new Usuario(user, pass, nombre, tipo);
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }
}