package MyProject;

import java.util.Calendar;
import java.util.Scanner;

public class Member {
    //04번
    void vaccinPossible(int birthYear){
        int age = Calendar.getInstance().get(Calendar.YEAR)-birthYear+1;
        if(age < 15 || age >= 65){
            System.out.println("무료예방접종이 가능합니다.");
        }else{
            System.out.println("무료접종 대상이 아닙니다.");
        }
    }

    void healthScreenings(int birthYear){
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
        Member member = new Member();
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
