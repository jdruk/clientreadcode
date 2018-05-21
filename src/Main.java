import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            while (true) {
                Socket client = serverSocket.accept();
                clientMessage(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void clientMessage(Socket client){
        try (Scanner scanner = new Scanner(client.getInputStream())) {
            while (scanner.hasNextLine())
                writeMessage(scanner.nextLine(), Keyboard.KEY_ENTER);
            closeConection(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConection(Socket client) {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void writeMessage(String message, int key){
        try {
            Keyboard keyboard = new Keyboard();
            keyboard.type(message, key);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}