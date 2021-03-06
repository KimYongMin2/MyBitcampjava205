package myproject.myProjectIO;

import common.util.ScannerUtil;
import java.io.*;

public class FileClass {
    public static void main(String[] args) {
        int button = 0;
        while (!(button==5)) {
            try {

                showMenu();
                button = getButton();
                fileControl(button);

            }catch (IOException e){
                e.printStackTrace();
            }catch (NumberFormatException e){
                System.out.println("숫자로 입력해주세요");
            }
        }
    }

    private static void fileControl(int button) throws IOException {
        switch (button) {
            case 1:
                FileWrite fileWrite = new FileWrite();
                fileWrite.fileWriteSave();
                break;
            case 2:
                FileRead fileRead = new FileRead();
                fileRead.showFileRead();
                break;
            case 3 :
                FileList fileList = new FileList();
                fileList.showFileList();
                break;
            case 4 :
                FileDelete fileDelete = new FileDelete();
                fileDelete.saveFileDelete();
                break;
            case 5:
                System.out.println("-----------------------------------------");
                System.out.println("종료합니다.");
                System.out.println("-----------------------------------------");
                break;
            default:
                System.out.println("-----------------------------------------");
                System.out.println("메뉴를 잘못입력했습니다");
                System.out.println("-----------------------------------------");
                break;
        }
    }

    private static int getButton() {
        System.out.print("원하는 기능을 선택하여 주세요 : ");
        return ScannerUtil.getInputInteger();
    }

    private static void showMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("1. 파일 저장");
        System.out.println("2. 파일 읽기");
        System.out.println("3. 리스트보기");
        System.out.println("4. 파일 삭제");
        System.out.println("5. 종료");
        System.out.println("-----------------------------------------");
    }
}
