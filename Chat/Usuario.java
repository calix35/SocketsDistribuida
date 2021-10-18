import java.io.DataOutputStream;

public class Usuario{
    String user;
    DataOutputStream dataOutputStream;

    public Usuario(String user, DataOutputStream dataOutputStream){
        this.user =  user;
        this.dataOutputStream = dataOutputStream;
    }

    public String getUser(){
        return this.user;
    }

    public void sendMsg(String msg){
        try {
            dataOutputStream.writeUTF(msg);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}