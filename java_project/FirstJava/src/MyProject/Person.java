package MyProject;

public class Person {
    String name;
    String telNum = "000-0000-0000";
    String perNum1 = "700000-0000000";
    long perNum2 = 7000000000000L;
    void showData() {
        System.out.println("회원 이름 : " + this.name);
        System.out.println("회원의 주민번호1 : " + perNum1 );
        System.out.println("회원의 주민번호2 : " + perNum2 );
    }

    public static void main(String[] args) {
        Person person = new Person();

        System.out.println("이름 : " + person.name );
        person.name = "손흥민";
        person.showData();

    }




}
