import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class ClientConnection extends Thread{

    private Socket socket;
    private InputStream inputStream;
    private DataInputStream dataInputStream;
    private OutputStream outputStream;
    private DataOutputStream dataOutputStream;

    public ClientConnection(Socket socket) throws IOException {
        this.socket =  socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        dataInputStream = new DataInputStream(inputStream);
        dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("Nuevo cliente conectado...");
    }

    public void closeConnection() throws IOException{
        inputStream.close();
        outputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
    
    public void run(){
        String msg=null;
        while(true){
            try {
                msg =  (String)dataInputStream.readUTF();   
            } catch (Exception e) {
                //TODO: handle exception
            }            
            if(msg.equals("bye"))
                break;
            System.out.println("Recibido: " + msg);
        }
        try {
            closeConnection();   
        } catch (Exception e) {
            //TODO: handle exception
        }        

    }

}


