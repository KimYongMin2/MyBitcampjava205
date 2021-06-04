package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ULConnectionTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");

            //URLConnection : url.openConnection()
            URLConnection connection = url.openConnection();

            InputStream inputStream = connection.getInputStream();

            int i = 0;

            while (true){
                i = inputStream.read();
                if ( i == -1){
                    break;
                }
                System.out.print((char) i);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
