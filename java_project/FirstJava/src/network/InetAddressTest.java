package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        String urlStr = "www.bitcamp.co.kr";
        InetAddress ip = null;
        try {
            ip = InetAddress.getByName(urlStr);
            System.out.println("호스트이름 : " + ip.getHostName());
            System.out.println("IP address : " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
