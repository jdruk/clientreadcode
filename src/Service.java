import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Service implements Runnable {

    private  ServerSocket serverSocket;
    private boolean statusService;
    private int key =  Keyboard.KEY_NONE;

    public void setKey(int key){
        this.key = key;
    }

    public  void run(){
        System.out.println("inicou");
        try {
            serverSocket = new ServerSocket(3000);
            while (true) {
                System.out.println("Wait client");
                Socket client = serverSocket.accept();
                clientMessage(client, key);
            }
            //System.out.println("Service stopped");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void clientMessage(Socket client, int key){
        try (Scanner scanner = new Scanner(client.getInputStream())) {
            while (scanner.hasNextLine())
                writeMessage(scanner.nextLine(), key);
            closeConnection(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection(Socket client) {
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
            System.out.println("Código: " + message);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public  boolean isStatusService() {
        return statusService;
    }

    public  void setStatusService(boolean statusService) {
        this.statusService = statusService;
    }
}