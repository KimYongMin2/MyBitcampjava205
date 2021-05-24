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
        calculator.plus(6,3);
        calculator.minus(6,3);
        calculator.multi(6,3);
        calculator.div(6,3);
    }
}
