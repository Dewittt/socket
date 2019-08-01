package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",65000);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write(new String("HELLO WORLD").getBytes());
        byte[] buff = new byte[1024];
        int ch = is.read(buff);
        String content = new String(buff,0,ch);
        System.out.println(content);



        is.close();
        os.close();
        socket.close();
    }
}
