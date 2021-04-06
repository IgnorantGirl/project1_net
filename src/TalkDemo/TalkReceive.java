package TalkDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {

    private int port;
    private String msgFrom;
    DatagramSocket socket = null;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            //1.创建一个Socket
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
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
                System.out.println(msgFrom+":"+receiverData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //关闭数据包
        socket.close();
    }
}
