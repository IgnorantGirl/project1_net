package lesson04;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UdpClientDemo01 {
    public static void main(String[] args) throws IOException {
        //1.建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        String str = "I am coming....";
        InetAddress address = InetAddress.getByName("127.0.0.1");        //发送给谁
        //2.建立包(参数：数据/数据的起始长度/数据的终止长度/发送给谁/端口号)
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(StandardCharsets.UTF_8),0,str.getBytes().length,address,9990);

        //3.发送包
        socket.send(datagramPacket);
        //关闭
        socket.close();
    }
}
