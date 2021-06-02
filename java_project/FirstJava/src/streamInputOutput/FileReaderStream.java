package streamInputOutput;

import java.io.*;

public class FileReaderStream {
    public static void main(String[] args) {
        try {
            Reader in = new FileReader("material/hyper.txt");
            char[] cbuf = new char[10];
            int readLen = 0;

            readLen = in.read(cbuf,0,cbuf.length);

//            for (int i = 0; i < readLen; i++) {
//                System.out.println(cbuf[i]);
//            }

//            System.out.println(new String(cbuf));

            System.out.println(cbuf);

            in.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
