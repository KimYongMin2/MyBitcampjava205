package myproject.myProjectException;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IntegerException extends Throwable {
    public static void main(String[] args) {
        try {
            System.out.print("태어난 년도를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            System.out.println(num);
        }catch (InputMismatchException e){
            System.out.println("숫자로 입력해주세요");
        }catch (IllegalStateException e){
            System.out.println("dd");
        }catch (NoSuchElementException e){
            System.out.println("dd");
        }
    }
}
