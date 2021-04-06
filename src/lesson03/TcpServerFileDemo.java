package lesson03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServerFileDemo {
    public static void main(String[] args) {
        try {
            //1.创建服务
            ServerSocket serverSocket = new ServerSocket(9000);
            //2.监听客户端的连接（阻塞式监听，一直等待客户端连接）
            Socket socket = serverSocket.accept();
            //3.获取输入流
            InputStream is = socket.getInputStream();
            //4.文件输出
            FileOutputStream fos = new FileOutputStream(new File("receiver.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            //通知客户端接收完毕了！
            //创建一个输出流
            OutputStream os = socket.getOutputStream();
            os.write("我已经接受完了，你可以关闭了".getBytes(StandardCharsets.UTF_8));
            //5.关闭资源
            fos.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
