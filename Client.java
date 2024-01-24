package SecondTask;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8000); // подключаем сокет на стандартный айпи компа и заданный на сервере порт
        PrintWriter clientOut = new PrintWriter(socket.getOutputStream());
        Scanner clientIn = new Scanner(socket.getInputStream());
        Scanner clientSend = new Scanner(System.in);
        while (true) {
            System.out.println("Your message to server: ");
            String s = clientSend.nextLine();
            clientOut.println(s);
            clientOut.flush();
            String s2 = clientIn.nextLine();
            System.out.println("Message from server: ");
            System.out.println(s2);
        }
    }
}
