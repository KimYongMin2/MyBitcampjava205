package fileStream;

import java.io.*;

public class FileMove {
    public static void main(String[] args) {
//        File myFile = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205\\material\\myJava", "origin.pdf");
//        File myFile = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205\\material\\myJava\\origin.pdf");
        File myFile = new File("C:"+File.separator+"Users"+File.separator+"bitcamp"+File.separator+"Documents"+File.separator+"MyBitcampjava205"+File.separator+
                "material"+File.separator+"myJava"+File.separator+"origin.pdf");
        System.out.println(myFile);

        if (myFile.exists()){
            System.out.println("파일이 존재합니다.");
        }else {
            System.out.println("파일이 존재하지 않습니다.");
            System.out.println("프로그램을 종료합니다.");
            return;
        }

        //새로운 폴더 생성: 경로생성 -> 생성

        File newDir = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205\\material\\yourJava");
        System.out.println("exist ?? -->" + newDir.exists());

        if(!newDir.exists()) {
            newDir.mkdir();
        }

        // 이동할 경로와 파일 이름
        File newFile = new File(newDir, myFile.getName());

        //이동

        myFile.renameTo(newFile);

        if (newFile.exists()){
            System.out.println("파일이동 성공");
        }else{
            System.out.println("파일이동 실패");
        }
    }
}
