package lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.要知道服务器的地址和端口号
            InetAddress ipName = InetAddress.getByName("127.0.0.1");
            int port = 9000;
            //2.创建一个socket连接
            socket = new Socket(ipName, port);
            //3.发送消息 IO流
            os = socket.getOutputStream();
            os.write("123344423".getBytes(StandardCharsets.UTF_8));
            os.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
