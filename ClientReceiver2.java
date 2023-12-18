import java.io.*;
import java.net.*;

public class ClientReceiver2 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 6376);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            if (msg != null) {
                System.out.println("Сообщение получено: " + msg);
                reader.close();
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(" Error : " + e);
        }
    }
}