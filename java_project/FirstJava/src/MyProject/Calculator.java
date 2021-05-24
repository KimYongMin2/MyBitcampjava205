package MyProject;

import java.util.Scanner;

public class Calculator {
    public void plus(int num1, int num2){
        System.out.println(num1 + num2);
    }

    public void minus(int num1, int num2){
        System.out.println(num1 - num2);
    }

    public void multi(int num1, int num2){
        System.out.println(num1 * num2);
    }

    public void div(double num1, double num2){
        System.out.println(num1 / num2);
    }

    public void round(double radius){
        System.out.println(2 * Math.PI * radius);
    }

    public void area(double radius){
        System.out.println(Math.PI * radius * radius);
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.plus(10, 20);
        calculator.minus(20, 10);
        calculator.div(10, 3);
        calculator.multi(2, 5);
        System.out.print("반지름을 입력해주세요 : ");
        double radius = getInputInteger();
        calculator.round(radius);
        calculator.area(radius);

    }

    private static int getInputInteger() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return  Integer.parseInt(input);
    }
}
