package myproject.myProjectThread;

import common.util.ScannerUtil;

import java.io.*;

public class CopyMain {
    public static void main(String[] args) {
        System.out.print("복사할 장소 폴더 명을 입력해주세요 : ");
        String copyDir = ScannerUtil.getInputString();
        File copyDirCheck = new File("C:\\Users\\USER\\Documents\\data\\" + copyDir);
        if (!copyDirCheck.exists()) {
            copyDirCheck.mkdir();
        }
        System.out.print("저장 될 파일명을 입력해주세요 : ");
        String copyFile = ScannerUtil.getInputString();
        File copyFileCheck = new File("C:\\Users\\USER\\Documents\\data\\" + copyDir + "\\" +copyFile +".txt");


        System.out.print("원본이 있는 장소 폴더 명을 입력해주세요 : ");
        String originDir = ScannerUtil.getInputString();
        File originCheck = new File("C:\\Users\\USER\\Documents\\data\\" + originDir);
        if (!originCheck.exists()) {
            System.out.println("존재하지 않습니다");
            return;
        }
        System.out.print("원본 파일명을 입력해주세요 : ");
        String originFile = ScannerUtil.getInputString();
        File originFileCheck = new File("C:\\Users\\USER\\Documents\\data\\" + originDir + "\\" + originFile + ".txt");


        CopyThread copyThread = new CopyThread(originFileCheck,copyFileCheck);
        copyThread.start();

    }
}
