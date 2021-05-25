package MyProject;

import java.util.Scanner;

public class Calculator {
    public long plus(int num1, int num2){ return (long)num1 + num2; }

    public long minus(int num1, int num2){
        return (long)num1 - num2;
    }

    public long multi(int num1, int num2){
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

    public void calculation(int num1, int num2){
        System.out.println("더하기 : "  + this.plus(num1, num2));
        System.out.println("빼기 : "  +this.minus(num1, num2));
        System.out.println("곱하기 : "  +this.div(num1, num2));
        System.out.println("나누기 : "  +this.multi(num1, num2));
    }

    public void calculationCircle(double radius){
        System.out.println("원둘레 : "  +this.round(radius));
        System.out.println("원넓이 : "  +this.area(radius));
    }


    public static void main(String[] args) {
        System.out.print("num1 값을 입력하여 주세요 : ");
        int num1 = getInputInteger();
        System.out.print("num2 값을 입력하여 주세요 : ");
        int num2 = getInputInteger();

        Calculator calculator = new Calculator();

        calculator.calculation(num1,num2);

        System.out.print("반지름을 입력해주세요 : ");
        double radius = getInputInteger();

        calculator.calculationCircle(radius);
    }

    private static int getInputInteger() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return  Integer.parseInt(input);
    }
}
