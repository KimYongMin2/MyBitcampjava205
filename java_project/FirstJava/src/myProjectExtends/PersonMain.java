package myProjectExtends;

public class PersonMain {
    public static void main(String[] args) {
        String idNumber = "960304";
        Person person = new Person("사람" , "960304");
        Male male = new Male("김용민", "960304-1******");
        Female female = new Female("김용순", "9504012******");

        person.hello();
        male.hello();
        female.hello();
    }
}
