package myproject.myProjectIO;

import common.util.ScannerUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class FileClass {
    public static void main(String[] args) {
        int button = 0;
        while (!(button==3)) {
            try {
                System.out.println("-----------------------------------------");
                System.out.println("1. 파일 저장     2. 파일 읽기     3. 종료");
                System.out.println("-----------------------------------------");
                System.out.print("원하는 기능을 선택하여 주세요 : ");
                button = ScannerUtil.getInputInteger();

                switch (button) {
                    case 1:
                        System.out.println("-----------------------------------------");
                        System.out.println("1. 파일 저장");
                        System.out.println("-----------------------------------------");
                        System.out.print("저장할 폴더 명을 입력해주세요 : ");
                        String saveDir = ScannerUtil.getInputString();
                        File newDir = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + saveDir);
                        if (!newDir.exists()) {
                            newDir.mkdir();
                        }

                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String now = simpleDateFormat.format(cal.getTime());

                        System.out.println("현재날짜 : " + now);
                        System.out.println("메모를 작성합니다");
                        System.out.println("---------------------------------------------------------");
                        System.out.print("제목을 입력하여 주세요 : ");
                        String title = ScannerUtil.getInputString();
                        System.out.print("1줄 내용을 입력하여 주세요 : ");
                        String contents = ScannerUtil.getInputString();

                        System.out.println();
                        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\bitcamp\\Documents\\myDir\\"
                                + saveDir + "\\" + now + "_" + title + ".txt"));


                        System.out.println("메모를 작성합니다");
                        out.write("현재시간 : " + now);
                        out.newLine();
                        out.write("제목 : " + title);
                        out.newLine();
                        out.write("내용 : " + contents);
                        out.newLine();
                        out.close();
                        System.out.println("작성 완료");
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("-----------------------------------------");
                        System.out.println("2. 파일 읽기");
                        System.out.println("-----------------------------------------");
                        System.out.println("폴더를 찾습니다");
                        System.out.print("찾을 폴더명을 입력하세요 : ");
                        String findDirname = ScannerUtil.getInputString();
                        File findDir = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname);
                        if (!findDir.exists()) {
                            System.out.println("파일이 존재하지 않습니다.");
                            System.out.println("종료합니다");
                            return;
                        } else {
                            System.out.println("파일을 찾습니다");
                            System.out.print("찾을 파일명을 입력하세요 : ");
                            String findFilename = ScannerUtil.getInputString();
                            File findFile = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + findDirname + "\\" + findFilename + ".txt");
                            if (!findFile.exists()) {
                                System.out.println("파일이 존재하지 않습니다.");
                                System.out.println("종료합니다");
                            } else {
                                BufferedReader in = new BufferedReader(new FileReader(findFile));
                                String str = null;

                                while (true) {
                                    str = in.readLine();

                                    if (str == null) {
                                        break;
                                    }

                                    System.out.println(str);
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("종료합니다.");
                        break;
                    default:
                        System.out.println("메뉴를 잘못입력했습니다");
                        break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }catch (NumberFormatException e){
                System.out.println("숫자로 입력해주세요");
            }
        }
    }
}
