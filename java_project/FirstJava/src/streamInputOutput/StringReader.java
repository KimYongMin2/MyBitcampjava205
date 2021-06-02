package streamInputOutput;

import java.io.*;

public class StringReader {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("material/String.txt"));

            String str = null;

            while (true){
                str = in.readLine();

                if(str == null){
                    break;
                }

                System.out.println(str);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
