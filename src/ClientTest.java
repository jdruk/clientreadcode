import java.io.IOException;
import java.net.Socket;

public class
        ClientTest {
    public static void main(String args[]) {

        try {
            Socket socket = new Socket("192.168.1.111", 3000);

            socket.getOutputStream().write("hello".getBytes());

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

