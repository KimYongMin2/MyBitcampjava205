package myProjectExtends;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
    String name;
    String idNumber;
    int age;
    public Person(String name, String idNumber){
        this.name = name;
        this.idNumber = idNumber;
    }
    public void hello(){
        age = Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"))) - Integer.parseInt(idNumber.substring(0,2))-1899;
        System.out.println("안녕하세요. 저는 " + name + "입니다. " + age + "살 입니다.");
    }
}
