package nio.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by xueyunlong on 17-9-18.
 */
public class Client {
    private Socket socket;

    public void init() throws IOException {
        socket = new Socket("127.0.0.1",1234);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            System.out.println(finalI);
            sendData();
        }
        socket.close();
    }
    public void sendData() throws IOException {
        String s = "11111";
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println(s);
        /*
        调用flush方法,强制将缓冲区的数据写入.
        */

        out.flush();
    }

    public static void main(String[] args) throws IOException {
        new Client().init();
    }
}
