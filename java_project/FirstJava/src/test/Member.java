package test;

public class Member extends BBB{
    void hello(){
        System.out.println("CCC");
    }

    public static void main(String[] args) {
        AAA aaa = new AAA();
        BBB bbb = new BBB();
        Member member = new Member();

        aaa.hello();
        bbb.hello();
        member.hello();

        AAA aab = new BBB();
        AAA aam = new Member();

        aab.hello();
        aam.hello();
    }

}

class AAA{
    void hello(){
        System.out.println("AAA");
    }
}

class BBB extends AAA{
    void hello(){
        System.out.println("BBB");
    }
}