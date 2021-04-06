package lesson02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务的端口ServerSocket
            serverSocket = new ServerSocket(9999);
            //2.等待客戶连接
            Socket accept = serverSocket.accept();
            //3.读取客户端的消息
            is = accept.getInputStream();
            //管道流:为了避免乱码问题，在输出输入流处套接一层
            baos = new ByteArrayOutputStream();
            //缓冲区
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
