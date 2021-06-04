package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {

        try {
            ServerSocket socket = new ServerSocket(9999);
            
            Socket s = socket.accept(); //Socket에서 연결요청이 올 때까지 대기
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
