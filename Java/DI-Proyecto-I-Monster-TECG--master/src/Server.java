import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *  Class Server in socket
 */
public class Server implements Runnable{
    private int port;
    private ServerSocket Server;
    private Socket Client;
    private boolean ServerActive;
    private DataOutputStream OUT;
    private DataInputStream IN;
    private String InMessage;
    public Server(){
        this.port = 1000;
        this.Server = null;
        this.Client = null;
        this.ServerActive = true;
    }

    public void setServerActive(boolean active){this.ServerActive = active;}
    public boolean isServerActive(){return this.ServerActive;}
    public Socket getClient(){return this.Client;}
    public ServerSocket getServer(){return this.Server;}
    public int getPort(){return this.port;}
    public void setPort(int port){this.port = port;}

    public void increasePort(){
        int port = getPort();
        setPort(port++);
    }
    public void SendMessage(String OutMessage){
        try{
            OUT = new DataOutputStream(this.Client.getOutputStream());
            OUT.writeUTF(OutMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setInMessage(String inMessage) {
        this.InMessage = inMessage;
    }

    public String getInMessage() {
        return InMessage;
    }
    public void run() {
        while(this.Server == null){
            try{
                this.Server = new ServerSocket(getPort());
            } catch (Exception e) {
                System.out.println(e);
                increasePort();
            }
        }
        while (this.Client == null){
            try{
                this.Client = this.Server.accept();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        while (isServerActive()){
            try{
                IN = new DataInputStream(this.Client.getInputStream());
                this.InMessage = IN.readUTF();
                setInMessage(this.InMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
