package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6501);
        byte[] buff = new byte[100];
        DatagramPacket packet = new DatagramPacket(buff,buff.length);

        byte[] data = packet.getData();

        String content = new String(data,0,packet.getLength());
        System.out.println(content);

        byte[] sendContent = String.valueOf(content.length()).getBytes();

         DatagramPacket paceteToClient = new DatagramPacket(sendContent,sendContent.length,packet.getAddress(),packet.getPort());
        socket.send(paceteToClient);
    }
}
