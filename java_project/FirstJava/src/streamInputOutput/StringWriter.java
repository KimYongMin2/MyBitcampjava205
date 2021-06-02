package streamInputOutput;

import java.io.*;

public class StringWriter {
    public static void main(String[] args) {
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter("material/String.txt"));

            System.out.println("쓰기 시작");

            out.write("손흥민 - 안녕하세요!!!");
            out.write("반갑습니다.");
            out.newLine();
            out.write("2021.06.02");
            out.write("손흥민 작성");

            out.close();

            System.out.println("작성 완료");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
