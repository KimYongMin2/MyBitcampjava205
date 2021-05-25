package MyProject;

import java.util.Scanner;

public class Calculator {
    public int plus(int num1, int num2){
        return num1 + num2;
    }

    public int minus(int num1, int num2){
        return num1 - num2;
    }

    public int multi(int num1, int num2){
        return num1 * num2;
    }

    public double div(double num1, double num2){
        return num1 / num2;
    }

    public double round(double radius){
        return 2 * Math.PI * radius;
    }

    public double area(double radius){
        return Math.PI * radius * radius;
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.plus(10, 20));
        System.out.println(calculator.minus(20, 10));
        System.out.println(calculator.div(10, 3));
        System.out.println(calculator.multi(2, 5));
        System.out.print("반지름을 입력해주세요 : ");
        double radius = getInputInteger();
        System.out.println(calculator.round(radius));
        System.out.println(calculator.area(radius));

    }

    private static int getInputInteger() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return  Integer.parseInt(input);
    }
}
