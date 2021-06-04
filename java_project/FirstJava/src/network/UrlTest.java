package network;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) {
        String urlStr = "https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=077&aid=0005213986";

        try {
            URL url = new URL(urlStr);

            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("HostName : " + url.getHost());
            System.out.println("Port : " + url.getPort());
            System.out.println("Default Port : " + url.getDefaultPort());
            System.out.println("Query : " + url.getQuery());
            System.out.println("Path : " + url.getPath());
            System.out.println("File : " + url.getFile());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
