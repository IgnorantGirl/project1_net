package lesson05;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=heidi");
            System.out.println(url.getProtocol());  //协议名
            System.out.println(url.getHost());  //主机名
            System.out.println(url.getPort());  //端口号
            System.out.println(url.getPath());  //全路径
            System.out.println(url.getFile());  //文件
            System.out.println(url.getQuery());  //参数

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
