package myproject.myProjectIO;

import common.util.ScannerUtil;

import java.io.*;

public class FileRead {
    public void showFileRead() throws IOException {
        showMyMenu();
        System.out.println("폴더를 찾습니다");
        System.out.print("찾을 폴더명을 입력하세요 : ");
        String findDirname = ScannerUtil.getInputString();
        File findDir = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname);
        if (!findDir.exists()) {
            unexistence();
        } else {
            System.out.println("파일을 찾습니다");
            System.out.print("찾을 파일명을 입력하세요 : ");
            String findFilename = ScannerUtil.getInputString();
            File findFile = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname + "\\" + findFilename + ".txt");
            if (!findFile.exists()) {
                unexistence();
            } else {
                showFileContents(findFile);
            }
        }
    }

    public void unexistence() {
        System.out.println("-----------------------------------------");
        System.out.println("존재하지 않습니다.");
        return;
    }

    public void showFileContents(File findFile) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(findFile));
        String str = null;
        System.out.println("-----------------------------------------");
        while (true) {
            str = in.readLine();
            if (str == null) {
                break;
            }
            System.out.println(str);
        }
    }

    public void showMyMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("2. 파일 읽기");
        System.out.println("-----------------------------------------");
    }
}
