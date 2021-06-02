package myproject.myProjectIO;

import java.io.*;
import java.util.ArrayList;

public class FootballPlayerFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //저장할 경로 지정
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\bitcamp\\Documents\\myDir\\player\\player.txt"));

        //리스트생성
        ArrayList<FootballPlayer> list = new ArrayList<>();
        //리스트에 정보 저장
        setListNewObject(list);
        //경로에 리스트 저장
        out.writeObject(list);
        //끝마침
        out.close();

        System.out.println("인스턴스 저장완료");

        //읽을 경로 지정
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\bitcamp\\Documents\\myDir\\player\\player.txt"));

        //복원순서는 저장순서에 맞게 복원
        ArrayList<FootballPlayer> list1 = (ArrayList<FootballPlayer>) in.readObject();

        System.out.println("복원된 인스턴스의 데이터를 출력");

        for (FootballPlayer footballPlayer : list1) {
            System.out.println(footballPlayer);
        }
    }

    private static void setListNewObject(ArrayList<FootballPlayer> list) {
        list.add(new FootballPlayer("홍길동",1,"한국", 20));
        list.add(new FootballPlayer("홍길순",2,"한국", 21));
        list.add(new FootballPlayer("김용민",3,"한국", 26));
        list.add(new FootballPlayer("김용순",4,"한국", 27));
        list.add(new FootballPlayer("김개똥",5,"한국", 24));
    }
}
