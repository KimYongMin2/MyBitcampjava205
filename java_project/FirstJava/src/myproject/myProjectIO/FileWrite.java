package myproject.myProjectIO;

import common.util.ScannerUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWrite {
    private String now, title, contents, saveDir;
    private File newDir;
    public void fileWriteSave() throws IOException {
       
        showMyMenu();
        setSaveDirname();
        DirExists(newDir);
        setMemoContents();
        saveFile(saveDir, now, title, contents);

    }

    private void setSaveDirname() {
        System.out.print("저장할 폴더 명을 입력해주세요 : ");
        saveDir = ScannerUtil.getInputString();
        newDir = new File("C:\\Users\\bitcamp\\Documents\\myDir\\" + saveDir);
    }

    private void DirExists(File newDir) {
        if (!newDir.exists()) {
            newDir.mkdir();
        }
    }

    public void setMemoContents(){
        now = calenderNowData();
        System.out.println("현재날짜 : " + now);
        System.out.println("---------------------------------------------------------");
        System.out.print("제목을 입력하여 주세요 : ");
        title = ScannerUtil.getInputString();
        System.out.print("1줄 내용을 입력하여 주세요 : ");
        contents = ScannerUtil.getInputString();
    }
    public void saveFile(String saveDir, String now, String title, String contents) throws IOException {
        System.out.println("---------------------------------------------------------");
        System.out.println("메모를 작성합니다");
        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\bitcamp\\Documents\\myDir\\"
                + saveDir + "\\" + now + "_" + title + ".txt"));
        out.write("현재시간 : " + now);
        out.newLine();
        out.write("제목 : " + title);
        out.newLine();
        out.write("내용 : " + contents);
        out.newLine();
        out.close();
        System.out.println("작성 완료");
        System.out.println();
    }

    public String calenderNowData() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now = simpleDateFormat.format(cal.getTime());
        return now;
    }

    public void showMyMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("1. 파일 저장");
        System.out.println("-----------------------------------------");
    }
}
