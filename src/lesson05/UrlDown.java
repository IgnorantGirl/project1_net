package lesson05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDown {
    public static void main(String[] args) throws IOException {
        //1.下载地址
        URL url = new URL("http://127.0.0.1:8080/heidi/securityFile.txt");
        //2.连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        //获得输入流
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("securityFile.txt");
        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();

    }
}
