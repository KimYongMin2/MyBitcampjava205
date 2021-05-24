package MyProject;

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

    public void div(int num1, int num2){
        System.out.println(num1 / num2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.plus(10, 20);
        calculator.minus(20, 10);
        calculator.div(10, 3);
        calculator.multi(2, 5);
    }
}
