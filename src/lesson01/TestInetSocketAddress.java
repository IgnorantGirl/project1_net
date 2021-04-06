package lesson01;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("localhost", 8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress1);

        //获取ip地址
        InetAddress address = inetSocketAddress.getAddress();
        System.out.println(address);
        //获取端口号
        int port = inetSocketAddress.getPort();
        System.out.println(port);

    }
}
