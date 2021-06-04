package network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=077&aid=0005213986");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            for (int i = 1; i < 8; i++) {
                System.out.print(httpURLConnection.getHeaderFieldKey(i));
                System.out.println(" : " + httpURLConnection.getHeaderField(i));
            }

            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
