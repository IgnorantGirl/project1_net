package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UdpReceiverDemo01 {
    public static void main(String[] args) throws IOException {
        //1.创建一个Socket
        DatagramSocket socket = new DatagramSocket(6000);

        while (true) {
            //2.创建一个包
            byte[] container = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
            //3.阻塞式接收数据包
            socket.receive(datagramPacket);
            //收到的数据
            byte[] data = datagramPacket.getData();
            String receiverData = new String(data, 0, data.length);
            if (receiverData.equals("bye")) break;
            //输出收到的数据
            System.out.println(receiverData);
        }
        //关闭数据包
        socket.close();
    }
}
