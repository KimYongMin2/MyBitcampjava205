package streamInputOutput;

import java.io.*;
import java.util.ArrayList;

public class ObjectSerializableList {
    public static void main(String[] args) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("material/Object1.ser"));

            ArrayList<Circle1> list = new ArrayList<>();
            list.add(new Circle1(1,2,3.4));
            list.add(new Circle1(5,6,7.8));
            list.add(new Circle1(9,10,11.12));
            list.add(new Circle1(1,2,3.4));
            list.add(new Circle1(1,2,3.4));
            out.writeObject(list);
            out.close();

            System.out.println("인스턴스 저장완료");

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("material/Object1.ser"));

            //복원순서는 저장순서에 맞게 복원
            ArrayList<Circle1> list1 = (ArrayList<Circle1>) in.readObject();

            System.out.println("복원된 인스턴스의 데이터를 출력");

            for (Circle1 circle : list1) {
                System.out.println(circle.toString());
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Circle1 implements Serializable {
    int x;
    int y;
    double r;

    public Circle1(int x, int y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void showData(){
        System.out.println("원점["+x+","+y+"]");
        System.out.println("반지름 : " + r);
    }
}
