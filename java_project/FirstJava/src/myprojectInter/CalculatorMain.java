package myprojectInter;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorInter calculatorInter1 = new CalculatorExtendAbs();
        CalculatorInter calculatorInter2 = new CalculatorImpInter();
        System.out.println(calculatorInter1.add(10,20));
        System.out.println(calculatorInter2.add(20,30));

    }
}
