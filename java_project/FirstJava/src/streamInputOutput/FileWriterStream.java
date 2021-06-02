package streamInputOutput;

import java.io.*;

public class FileWriterStream {
    public static void main(String[] args) {
        try {
            System.out.println("문자 스트림 생성");
            Writer out = new FileWriter("material/hyper.txt");

            char c1 = 'A';
            char c2 = 'B';
            String str = "CD";
            int c3 = 3;

            out.write(c1);
            out.write(c2);
            out.write(str);
            out.write(c3);
            out.write('E');
            out.write("FG");
            out.write(4);

            out.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
