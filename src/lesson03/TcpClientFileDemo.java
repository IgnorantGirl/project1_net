package lesson03;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpClientFileDemo {
    public static void main(String[] args) {
        Socket socket = null;
        FileInputStream inputStream = null;
        try {
            //1.创建一个Socket连接
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
            //2.创建一个输出流
            OutputStream os = socket.getOutputStream();
            //3.读取文件
            inputStream = new FileInputStream(new File("testTcp.png"));
            //4.写入文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
             //通知服务器 已经发送完毕
            socket.shutdownOutput();//重要！！！！
            //确定服务器接收完毕，才能够断开连接
            //接收消息
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while((len2=is.read(buffer2))!=-1){
                baos.write(buffer2,0,len2);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //5.关闭资源
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
