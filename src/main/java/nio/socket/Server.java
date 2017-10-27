package nio.socket;



import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xueyunlong on 17-9-18.
 */
public class Server {
    private ServerSocket serverSocket;
    public void receiveData() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    String s = IOUtils.toString(socket.getInputStream());
                    System.out.println(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    public void init() throws IOException {
        serverSocket = new ServerSocket(1234);
        receiveData();
    }

    public static void main(String[] args) throws IOException {
        new Server().init();
    }
}
