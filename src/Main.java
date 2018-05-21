import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Aguardando cliente");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("cliente entrou");

                Scanner scanner = new Scanner(socket.getInputStream());

                while (scanner.hasNextLine()) {
                    String msg = scanner.nextLine();
                    Keyboard keyboard = new Keyboard();
                    keyboard.type(msg, true);
                    System.out.println(msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}