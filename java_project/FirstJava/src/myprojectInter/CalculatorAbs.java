package myprojectInter;

public abstract class CalculatorAbs implements CalculatorInter {
    void showName(){
        System.out.println("추상");
    }
    public long add(long n1, long n2){
        System.out.println("추상");
        return n1+n2;
    }
}
