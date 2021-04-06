package TalkDemo;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * 多线程收发数据
 */
public class TalkSend implements Runnable {

    private int fromPort;
    private String toIP;
    private int toPort;
    DatagramSocket socket = null;
    InputStreamReader stream = null;
    BufferedReader reader = null;

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        //1.创建一个Socket
        try {
            socket = new DatagramSocket(this.fromPort);
            //准备数据:从控制台读取数据
            stream = new InputStreamReader(System.in);
            reader = new BufferedReader(stream);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            while (true) {
                String data = reader.readLine();
                if (data.equals("bye")) break;
                byte[] dataArry = data.getBytes(StandardCharsets.UTF_8);
                //2.创建一个包
                DatagramPacket datagramPacket = new DatagramPacket(dataArry, 0, dataArry.length, InetAddress.getByName(this.toIP), this.toPort);
                //3.发送数据包
                socket.send(datagramPacket);
            }
            //关闭数据包
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
