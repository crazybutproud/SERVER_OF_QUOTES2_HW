package SecondTask;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000); // создаем сервер на своем ноуте на 8000 порту
        Socket socket = serverSocket.accept();
        Scanner serverIn = new Scanner(socket.getInputStream()); // считывает входящие данные от клиента
        PrintWriter serverOut = new PrintWriter(socket.getOutputStream()); // считывает исходящие данные
        Scanner serverSend = new Scanner(System.in); // считывает данные с консоли для отправки клиенту
        while (serverIn.hasNext()) { // пока есть входящие значения
            System.out.println("Message from client: ");
            System.out.println(serverIn.nextLine()); //сообщение от клиента
            System.out.println("Your message to client: ");
            String s = serverSend.nextLine(); // считываем в строку данные с консоли
            serverOut.println(s); //отправляем данные
            serverOut.flush();//обнуляем данные
        }

        serverOut.close();
        serverSend.close();
        serverIn.close();
        serverSocket.close();

    }
}
