package myproject.MyProject1;

import java.util.Calendar;
import java.util.Scanner;

public class Member04 {
    //04번
    void vaccinPossible(int birthYear){
        System.out.println("-- 독감 예방 접종 가능 여부를 확인합니다. --");
        int age = Calendar.getInstance().get(Calendar.YEAR)-birthYear+1;
        // if(!(age>=15 && age<65)) 좁은 범위를 표현하고 논리부정을 하는게 편하다.
        if(age < 15 || age >= 65){
            System.out.println("무료예방접종이 가능합니다.");
        }else{
            System.out.println("무료접종 대상이 아닙니다.");
        }
    }

    void healthScreenings(int birthYear){
        System.out.println("-- 건강검진 대상 여부를 판별합니다 --");
        int age = Calendar.getInstance().get(Calendar.YEAR)-birthYear+1;
        if(age >= 20){
            if(age % 2 == Calendar.getInstance().get(Calendar.YEAR) % 2){
                System.out.println("건강검진 검사대상입니다.");
                if(age >= 40){
                    System.out.println("암 검사도 가능합니다.");
                }
            }else{
                System.out.println("건강검진 검사대상이 아닙니다.");
            }
        }
    }
    public static void main(String[] args) {
        // 04번
        Member04 member = new Member04();
        System.out.print("태어난 년도를 입력해주세요 : ");
        int birthYear = getInputInteger();
        member.vaccinPossible(birthYear);
        member.healthScreenings(birthYear);
    }
    private static int getInputInteger() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return  Integer.parseInt(input);
    }
}
