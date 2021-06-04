package socket;

import common.util.CloseUtil;
import common.util.ScannerUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MessageClient {
    public static void main(String[] args) {
        Socket socket = null;

        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket("localhost", 8888);

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String str1 = null; //받기
            String str2 = " "; //보내기

            while (!str2.equals("exit")){
                str2 = ScannerUtil.getInputString();
                dataOutputStream.writeUTF(str2);


                str1 = dataInputStream.readUTF();
                System.out.println("Server Message : " + str1);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(socket);
            CloseUtil.close(dataInputStream);
            CloseUtil.close(dataOutputStream);
        }
    }
}
