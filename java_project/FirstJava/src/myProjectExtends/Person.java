package myProjectExtends;


import java.util.Calendar;

public class Person {
    private String name;
    private String idNumber;
    private int age;
    private char checkSince;
    public Person(String name, String idNumber){
        this.name = name;
        this.idNumber = idNumber;
    }
    public void hello(){
        checkSince = idNumber.charAt(6);
        if (checkSince == '-'){
            checkSince = idNumber.charAt(7);
        }
        if (checkSince=='1'||checkSince=='2'){
            this.age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(idNumber.substring(0,2))-1899;
        }else if(checkSince=='3'||checkSince=='4'){
            this.age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(idNumber.substring(0,2))-1999;
        }
        System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.age + "살 입니다.");
    }
}
