import javax.activation.DataHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vamsi on 8/10/17.
 */
public class AppServer {
    public static void main(String[] args){
        try{
            ServerSocket server=new ServerSocket(8080);
            DataHandler dh;
            Socket sc=new Socket();
            System.out.println(System.getProperty("user.dir"));
            while(true)
            {
                System.out.println("Waiting for client \n to connect");
                sc=server.accept();
                System.out.println("App connected"+sc.getInetAddress());
                new Saving(sc);
            }
        }
        catch(IOException i)
        {
            System.out.println("Please re check connection");
            i.printStackTrace();
        }
    }
}
