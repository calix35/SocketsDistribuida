import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

import java.util.ArrayList;

public class ClientConnection extends Thread{

    private Socket socket;
    private InputStream inputStream;
    private DataInputStream dataInputStream;
    private OutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private ArrayList<Usuario> usuarios;

    public ClientConnection(Socket socket, ArrayList<Usuario>usuarios) throws IOException {
        this.usuarios =  usuarios;
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
        String user;
        try {
            user = (String)dataInputStream.readUTF();
            usuarios.add(new Usuario(user, dataOutputStream));

            //Recibiendo de los clientes
            while(true){
                String msg = (String)dataInputStream.readUTF();                
                if(msg.equals("lu")){//lista de usuarios
                    String lista="";
                    for(int i=0;i<usuarios.size();i++)
                        lista =  lista + usuarios.get(i).getUser() + "\n";                        
                    dataOutputStream.writeUTF("Server");
                    dataOutputStream.writeUTF(lista);
                }else if(msg.equals("sm")){//Mensaje a un usuario
                    String userMsg =  (String)dataInputStream.readUTF();
                    String mensaje =  (String)dataInputStream.readUTF();
                    for(int i = 0; i<usuarios.size(); i++)
                        if(usuarios.get(i).getUser().equals(userMsg)){
                            usuarios.get(i).sendMsg(user);
                            usuarios.get(i).sendMsg(mensaje);
                            break;
                        }
                }else if(msg.equals("exit")){
                    break;
                }else{//Mensaje a todos los usuarios
                    for(int i = 0; i<usuarios.size(); i++){
                        if(!usuarios.get(i).getUser().equals(user)){
                            usuarios.get(i).sendMsg(user);
                            usuarios.get(i).sendMsg(msg);
                        }
                    }
                }
            }

            closeConnection(); 
        } catch (Exception e) {
            //TODO: handle exception
        }                
    }

}


