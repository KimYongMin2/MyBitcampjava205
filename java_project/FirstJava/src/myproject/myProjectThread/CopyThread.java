package myproject.myProjectThread;

import java.io.*;

public class CopyThread extends Thread{
    File originFile;
    File copyFile;

    public CopyThread(File originFile, File copyFile) {
        this.originFile = originFile;
        this.copyFile = copyFile;
    }

    @Override
    public void run() {
        try {
            InputStream in = new FileInputStream(originFile);
            OutputStream out = new FileOutputStream(copyFile);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
