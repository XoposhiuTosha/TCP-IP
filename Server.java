import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Server {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Socket receiver = null;
        Socket sender = null;
        Socket receiver2 = null;
        try {
            System.out.println("Server started");
            ServerSocket receiver1 = new ServerSocket(6375);
            ServerSocket receiver3 = new ServerSocket(6376);
            ServerSocket sender1 = new ServerSocket(6789);
            receiver = receiver1.accept();
            sender = sender1.accept();
            receiver2 = receiver3.accept();
            BufferedReader reader = new BufferedReader((new InputStreamReader(sender.getInputStream())));
            String msg = reader.readLine();
            String[] data = msg.split(" ", 2);
            String receinvind = data [0];
            msg = data [1];
            if (receinvind.equals("0"))
            {
                PrintStream ps = new PrintStream(receiver.getOutputStream());
                ps.println(msg);
                ps.flush();
                receiver.close();
            }
            else
            {
                PrintStream ps = new PrintStream(receiver2.getOutputStream());
                ps.println(msg);
                ps.flush();
                receiver2.close();
            }

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
}
