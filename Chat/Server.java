import java.net.ServerSocket;
import java.io.IOException;

import java.util.ArrayList;

public class Server{
    public static void main(String[] args) throws IOException {        
        ServerSocket serverSocket = new ServerSocket(9000);
        ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
        System.out.println("Esperando conexiones en el puerto 9000...");

        
        while(true){
            Thread conexion = new ClientConnection(serverSocket.accept(), usuarios);//Acepta conexion
            conexion.start();
        }

    }
}

