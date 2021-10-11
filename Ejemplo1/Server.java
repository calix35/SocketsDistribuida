
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;

public class Server{
    public static void main(String[] args) throws IOException {
        ServerSocket server =  new ServerSocket(9000);

        //Acepta una nueva conexion con el servidor
        System.out.println("Esperando conexion en el puerto 9000...");
        Socket socket_server = server.accept();//Metodo bloqueante

        OutputStream socket_os = socket_server.getOutputStream();

        DataOutputStream socket_dos = new DataOutputStream(socket_os);

        socket_dos.writeUTF("hola");

        InputStream socket_is = socket_server.getInputStream();

        DataInputStream socket_dis = new DataInputStream(socket_is);

        String msg =  (String)socket_dis.readUTF();

        System.out.print("Mensaje recibido: ");
        System.out.println(msg);

        socket_dos.writeUTF("ok");

        /* Cerrar todas las conexiones */
        socket_dos.close();
        socket_dis.close();
        socket_is.close();
        socket_os.close();
        socket_server.close();
        server.close();


    }
}

/*

    ServerSocket(port):
        port -  el numero de puerto que se va a utilizar para hacer la comunicacion (0-1023, 1024-65536)

        accept(): Aceptar una nueva conexion con el servidor y regresa un Socket (sirve para comunicarse con el cliente)

    Socket 

 */


 /*
 
    Servidor                           Cliente
    espera_conexion      <------       conecta
      hola               ------>       recibe
      adios              <------       adios

 */