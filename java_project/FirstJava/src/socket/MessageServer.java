package socket;

import common.util.CloseUtil;
import common.util.ScannerUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            serverSocket = new ServerSocket(8888);

            socket = serverSocket.accept();

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String str1 = null; //받는
            String str2 = " "; //보내는

            while (!str2.equals("exit")) {
                str1 = dataInputStream.readUTF();
                System.out.println("Client Message" + str1);

                str2 = ScannerUtil.getInputString();
                dataOutputStream.writeUTF(str2);
                dataOutputStream.flush();
            }




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(serverSocket);
            CloseUtil.close(socket);
            CloseUtil.close(dataInputStream);
            CloseUtil.close(dataOutputStream);
//            if (dataInputStream != null){
//                try {
//                    dataInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (dataOutputStream != null){
//                try {
//                    dataOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null){
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (serverSocket != null){
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }


        }

    }
}
