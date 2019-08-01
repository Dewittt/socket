package socket;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        byte[] buff = "hello world".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buff,buff.length,address,6501);
        byte[] data = new byte[100];

        DatagramPacket receviedPacket = new DatagramPacket(data,data.length);
        socket.receive(receviedPacket);
        String content = new String(receviedPacket.getData(),0,receviedPacket.getLength());
        System.out.println(content);
    }
}
