package myproject.myProjectIO;

import common.util.ScannerUtil;

import java.io.File;
import java.io.IOException;

public class FileDelete {
    private String findDirname, findFilename;
    private File findDir, findFile;
    public void saveFileDelete() throws IOException {
        showMyMenu();
        setFindDelDirName();
        if (!findDir.exists()) {
            unexistence();
        } else {
            setDelFileName();
            if (!findFile.exists()) {
                unexistence();
            } else {
                fileDel();
            }
        }
    }

    private void fileDel() {
        findFile.delete();
        System.out.println("-----------------------------------------");
        System.out.println("삭제 완료");
    }

    private void setDelFileName() {
        System.out.print("삭제할 파일명을 입력하세요 : ");
        findFilename = ScannerUtil.getInputString();
        findFile = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname + "\\" + findFilename + ".txt");
    }

    private void setFindDelDirName() {
        System.out.println("파일을 삭제합니다");
        System.out.print("삭제할 파일이 존재하는 폴더명을 입력하세요 : ");
        findDirname = ScannerUtil.getInputString();
        findDir = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname);
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
