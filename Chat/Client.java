import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

import java.util.Scanner;

public class Client extends Thread{
    private Scanner sc =  new Scanner(System.in);
    private Socket socket_client;
    private OutputStream os;
    private DataOutputStream dos;
    private InputStream is;
    private DataInputStream dis;

    public Client(){  
        try {
            socket_client =  new Socket("localhost",9000);        
            os = socket_client.getOutputStream();
            dos = new DataOutputStream(os);
            is = socket_client.getInputStream();
            dis = new DataInputStream(is);
            // Leyendo el nombre de usuario
            System.out.print("Usuario: ");
            String user = sc.nextLine();
            dos.writeUTF(user);
        } catch (Exception e) {
            //TODO: handle exception
        }              
    }

    public void help(){
        System.out.println("help - Ver este anuncio");
        System.out.println("lu - Lista de usuarios");
        System.out.println("sm - Enviar mensaje a usuario");
        System.out.println("exit - Desconectarse");
        System.out.println("Enviar mensaje...");
    }

    public void enviar_mensajes(){
        try {
            String msg;
            while(true){                    
                System.out.print(" > ");           
                msg = sc.nextLine();                        
                if(msg.equals("help")){
                    help();
                }else{
                    dos.writeUTF(msg);
                    if(msg.equals("sm")){
                        System.out.print("\tUsuario: ");
                        msg = sc.nextLine();
                        dos.writeUTF(msg);
                        System.out.print("\tMsg: ");
                        msg = sc.nextLine();
                        dos.writeUTF(msg);
                    }
                }
                if(msg.equals("exit"))
                    break;
            }
            
            socket_client.close();
        } catch (Exception e) {
            //TODO: handle exception
        }        
    }

    public void run(){
        try {
            while(true){
                String user = (String)dis.readUTF();
                String msg = (String)dis.readUTF();
                System.out.println(user + " > " + msg);           
            }
        } catch (Exception e) {
            //TODO: handle exception
        }        
    }

    public static void main(String[] args) throws IOException{
        
        Client cliente = new Client();
        cliente.start();
        cliente.enviar_mensajes();

    }
}
