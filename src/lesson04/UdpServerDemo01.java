package lesson04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerDemo01 {

    //需要等待客户端的连接
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9990);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);  //阻塞式接收
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
