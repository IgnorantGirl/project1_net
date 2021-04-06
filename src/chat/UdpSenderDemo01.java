package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws IOException {
        //1.创建一个Socket
        DatagramSocket socket = new DatagramSocket(6666);
        //准备数据:从控制台读取数据
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(stream);
       while(true){
           String data = reader.readLine();
           if(data.equals("bye")) break;;
           byte[] dataArry = data.getBytes(StandardCharsets.UTF_8);

           //2.创建一个包
           DatagramPacket datagramPacket = new DatagramPacket(dataArry,0,dataArry.length,InetAddress.getByName("127.0.0.1"),6000);
           //3.发送数据包
           socket.send(datagramPacket);
       }
        //关闭数据包
        socket.close();
    }
}
