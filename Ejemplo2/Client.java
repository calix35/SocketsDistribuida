import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws IOException{
        Scanner sc =  new Scanner(System.in);
        String msg;
        Socket socket_client =  new Socket("localhost",9000);        
        OutputStream os = socket_client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        
        while(true){
            System.out.print("Msg (bye to exit) > ");
            msg = sc.nextLine();
            dos.writeUTF(msg);
            if(msg.equals("bye"))
                break;
        }
        
        socket_client.close();

    }
}
