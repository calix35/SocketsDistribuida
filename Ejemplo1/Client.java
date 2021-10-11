import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class Client{
    public static void main(String[] args) throws IOException{
        Socket socket_client =  new Socket("localhost",9000);

        InputStream socket_is = socket_client.getInputStream();

        DataInputStream socket_dis = new DataInputStream(socket_is);

        String msg =  (String)socket_dis.readUTF();

        System.out.print("Mensaje recibido: ");
        System.out.println(msg);

        OutputStream socket_os = socket_client.getOutputStream();

        DataOutputStream socket_dos = new DataOutputStream(socket_os);

        socket_dos.writeUTF("adios");

        msg =  (String)socket_dis.readUTF();
        System.out.print("Mensaje recibido: ");
        System.out.println(msg);

        socket_dis.close();
        socket_dos.close();                
        socket_os.close();
        socket_is.close();
        socket_client.close();

    }
}

/*
    La clase Socket:
        - Socket(ip,port):
            ip: la direccion ip de la computadora donde se esta ejecutando el servidor (si es local, se puede poner localhost)
            port: El puerto donde esta trabajando el servidor

*/