package myproject.myprojectAPI;

public class Person {
    String name;
    String personNumber;
    Person(String name, String personNumber){
        this.name = name;
        this.personNumber = personNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if((obj instanceof Person)&& obj != null){
            return ((Person) obj).personNumber.equals(personNumber);
        }
        return false;
    }

    public static void main(String[] args) {
        Person person1 = new Person("김용민", "960304");
        Person person2 = new Person("홍길동", "960304");
        Person person3 = new Person("홍길동", "990033");

        System.out.println(person1.equals(person2));
        System.out.println(person3.equals(person2));
    }
}
