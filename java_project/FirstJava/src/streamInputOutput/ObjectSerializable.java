package streamInputOutput;

import java.io.*;

public class ObjectSerializable {
    public static void main(String[] args) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("material/Object.ser"));
            out.writeObject(new Circle(1,1,2.4));
            out.writeObject(new Circle(3,5,7.9));
            out.writeObject("Hello");
            out.close();

            System.out.println("인스턴스 저장완료");

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("material/Object.ser"));

            //복원순서는 저장순서에 맞게 복원
            Circle c1 = (Circle) in.readObject();
            Circle c2 = (Circle) in.readObject();
            String str = (String) in.readObject();

            System.out.println("복원된 인스턴스의 데이터를 출력");
            
            c1.showData();
            c2.showData();
            System.out.println(str);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Circle implements Serializable {
    int x;
    int y;
    double r;

    public Circle(int x, int y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void showData(){
        System.out.println("원점["+x+","+y+"]");
        System.out.println("반지름 : " + r);
    }
}
