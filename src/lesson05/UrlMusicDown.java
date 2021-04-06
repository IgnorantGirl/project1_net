package lesson05;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlMusicDown {
    public static void main(String[] args) throws Exception {
        //1.下载地址
        URL url = new URL("https://m10.music.126.net/20210406231933/714b2817c82f46e1f4f76eb341322a30/yyaac/obj/wonDkMOGw6XDiTHCmMOi/3214904201/f203/bbe4/d155/beef57f0e6b5faa6005ff5658bc0af2a.m4a");
        //2.连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("a.m4a");
        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();
    }
}
