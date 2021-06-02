package streamInputOutput;

import java.io.*;


public class FilterStreamCopy {
    public static void main(String[] args) throws IOException {
        try {
            InputStream in = new FileInputStream("material/origin.pdf");
            OutputStream out = new FileOutputStream("material/copy.pdf");

            BufferedInputStream fin = new BufferedInputStream(in);
            BufferedOutputStream fout = new BufferedOutputStream(out);

            int copyByte=0;
            int bData;
            while(true)
            {
                bData=fin.read();
                if(bData==-1) {
                    break;
                }
                fout.write(bData);
                copyByte++;
            }
            fin.close();
            fout.close();
            System.out.println("복사된 바이트 크기 "+ copyByte);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
