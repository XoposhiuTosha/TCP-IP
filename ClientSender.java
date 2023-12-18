import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ClientSender {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Socket socket = null;
        try {
            ArrayList<String> receiverNames = new ArrayList<String>();
            receiverNames.add("Client1");
            receiverNames.add("Client2");
            System.out.println("Available receivers: ");
            for (int i = 0; i < receiverNames.size(); i++) {
                System.out.println(i + " - " + receiverNames.get(i));
            }
            System.out.print("Enter receiver number: ");
            String sentence = scan.nextLine();
            System.out.print("Enter message: ");
            sentence += " ";
            sentence += scan.nextLine();
            socket = new Socket(InetAddress.getLocalHost(), 6789);
            System.out.println("Сообщение отправлено!");
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(sentence);
            ps.flush();
            socket.close();
        } catch (IOException e) {
            System.out.println(" Ошибка : " + e);
        }
    }
}
