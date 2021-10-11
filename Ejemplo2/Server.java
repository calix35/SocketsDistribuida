import java.net.ServerSocket;
import java.io.IOException;

public class Server{
    public static void main(String[] args) throws IOException {        
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Esperando conexiones en el puerto 9000...");

        
        while(true){
            Thread conexion = new ClientConnection(serverSocket.accept());//Acepta conexion
            conexion.start();
        }

    }
}

/*
    while(true){
        Print hola
        while(true){

        }
    }

*/