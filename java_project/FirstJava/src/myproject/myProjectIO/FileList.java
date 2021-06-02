package myproject.myProjectIO;

import common.util.ScannerUtil;

import java.io.File;

public class FileList {
    public void showFileList() {
        showMyMenu();
        System.out.println("파일의 리스트를 보여줍니다");
        System.out.print("보고싶은 폴더를 입력하세요 : ");
        String findDirname = ScannerUtil.getInputString();
        System.out.println("-----------------------------------------");
        File findDir = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname);
        if (!findDir.exists()) {
            unexistence();
        } else {
            File files[] = findDir.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println("file: " + files[i].getName());
            }
        }
    }

    public void showMyMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("3. 파일 리스트 보기");
        System.out.println("-----------------------------------------");
    }

    public void unexistence() {
        System.out.println("-----------------------------------------");
        System.out.println("존재하지 않습니다.");
        return;
    }
}
