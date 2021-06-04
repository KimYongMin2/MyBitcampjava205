package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        //SocketServer Ip, Port connection : Socket 생성
        try {
            Socket  socket = new Socket("localhost", 9999);
            if(socket != null){
                System.out.println("서버접속 완료");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
