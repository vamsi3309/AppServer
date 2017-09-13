import java.io.*;
import java.net.Socket;

/**
 * Created by vamsi on 8/10/17.
 */
public class Saving {

    Socket save_sc;
    public Saving(Socket sc)
    {
        save_sc = sc;
        save_process();
    }
    public void save_process(){
        try {
            DataInputStream din = new DataInputStream(save_sc.getInputStream());
            String filename = din.readUTF();
            File getfile = new File(System.getProperty("user.dir") + "/" + filename);
            getfile.createNewFile();
            OutputStream write_file = new FileOutputStream(getfile);
            byte[] bytes = new byte[1024];
            int limit;
            while ((limit = din.read(bytes)) > 0) {
                write_file.write(bytes, 0, limit);
            }
            write_file.close();
            din.close();
            save_sc.close();
            System.out.println("Connection closed");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


