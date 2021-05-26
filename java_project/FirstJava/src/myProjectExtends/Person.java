package myProjectExtends;


import java.util.Calendar;

public class Person {
    private String name;
    private String idNumber;
    private int age;
    public Person(String name, String idNumber){
        this.name = name;
        this.idNumber = idNumber;
    }
    public void hello(){
        this.age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(idNumber.substring(0,2))-1899;
        System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.age + "살 입니다.");
    }
}
