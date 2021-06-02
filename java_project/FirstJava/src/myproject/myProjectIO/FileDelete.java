package myproject.myProjectIO;

import common.util.ScannerUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDelete {
    public void saveFileDelete() throws IOException {
        showMyMenu();
        System.out.println("파일을 삭제합니다");
        System.out.print("삭제할 파일이 존재하는 폴더명을 입력하세요 : ");
        String findDirname = ScannerUtil.getInputString();
        File findDir = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname);
        if (!findDir.exists()) {
            unexistence();
        } else {
            System.out.print("삭제할 파일명을 입력하세요 : ");
            String findFilename = ScannerUtil.getInputString();
            File findFile = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname + "\\" + findFilename + ".txt");
            if (!findFile.exists()) {
                unexistence();
            } else {
                findFile.delete();
                System.out.println("-----------------------------------------");
                System.out.println("삭제 완료");
            }
        }
    }

    public void unexistence() {
        System.out.println("-----------------------------------------");
        System.out.println("존재하지 않습니다.");
        return;
    }



    public void showMyMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("4. 파일 삭제");
        System.out.println("-----------------------------------------");
    }
}