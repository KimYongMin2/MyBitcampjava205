package myProjectExtends;

public class Person {
    String name;
    String idNumber;
    int age;
    public Person(String name, String idNumber){
        this.name = name;
        this.idNumber = idNumber;
    }
    public void hello(){
        age = 121 - Integer.parseInt(idNumber.substring(0,1));
        System.out.println("안녕하세요. 저는 " + name + "입니다. " + age + "살 입니다.");
    }
}
