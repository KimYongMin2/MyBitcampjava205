package MyProject2;

import java.util.Scanner;

public class Member {
    String name;
    String telNum;
    String subject;
    int grade;
    String email;
    int birth;
    String address;
    public void showInfo() {
        System.out.println("name= " + name + '\'' +
                ", telNum='" + telNum + '\'' +
                ", subject='" + subject + '\'' +
                ", grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", address='" + address);
    }
    public Member(String name, String telNum, String subject, int grade, String email, int birth, String address){
        this.name = name;
        this.telNum = telNum;
        this.subject = subject;
        this.grade = grade;
        this.email = email;
        this.birth = birth;
        this.address = address;
    }

    public Member(String name, String telNum, String subject, int grade, String email){
        this(name,telNum,subject,grade,email,00000000,"주소미입력");
    }

    public static void main(String[] args) {
        System.out.print("이름을 입력하여주세요 : ");
        String name = getInputString();
        System.out.print("전화번호를 입력하여주세요 : ");
        String telNum = getInputString();
        System.out.print("전공을 입력하여주세요 : ");
        String subject = getInputString();
        System.out.print("학년을 입력하여주세요 : ");
        int grade = getInputInteger();
        System.out.print("email을 입력하여주세요 : ");
        String email = getInputString();
        System.out.print("생일을 입력하여주세요 : ");
        int birth = getInputInteger();
        System.out.print("주소를 입력하여주세요 : ");
        String address = getInputString();

        Member member1 = new Member(name, telNum, subject, grade, email);
        Member member2 = new Member(name, telNum, subject, grade, email, birth, address);

        member1.showInfo();
        member2.showInfo();
    }

    private static int getInputInteger() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return  Integer.parseInt(input);
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
