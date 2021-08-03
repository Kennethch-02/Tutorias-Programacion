import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 * Client class for server management
 */
public class Client implements Runnable{
    private Socket Client;
    private String ipAddress;
    private int port;    private boolean ClientActive;
    private DataOutputStream OUT;
    private DataInputStream IN;
    private String InMessage;

    public void setClientActive(boolean active){this.ClientActive = active;}
    public boolean isClientActive(){return this.ClientActive;}
    public Socket getClient(){return this.Client;}
    public int getPort(){return this.port;}
    public void setPort(int port){this.port = port;}
    public Client(String ipAddress, int port){
        this.ipAddress = ipAddress;
        this.port = port;
        this.Client = null;
        this.ClientActive = true;
    }
    public void SendMessage(String OutMessage){
        try{
            OUT = new DataOutputStream(this.Client.getOutputStream());
            OUT.writeUTF(OutMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getInMessage() {
        return InMessage;
    }

    public void setInMessage(String inMessage) {
        this.InMessage = inMessage;
    }
    /**
     *method that runs the client's operation
     */
    public void run() {
        while (this.Client == null){
            try{
                this.Client = new Socket(this.ipAddress, this.port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (isClientActive()){
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
