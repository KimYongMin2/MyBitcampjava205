package myprojectInter;

interface CalulatorInter {
    long add(long n1, long n2);
    long substract(long n1, long n2 );
    long multiply(long n1, long n2 );
    double divide(double n1, double n2 );
}

 abstract class CalculatorAbs implements CalulatorInter {
    String name;
    void showName(){
        System.out.println(name);
    }
 }

public class CalculatorMain implements CalulatorInter{

    @Override
    public long add(long n1, long n2) {
        return n1+n2;
    }

    @Override
    public long substract(long n1, long n2) {
        return n1-n2;
    }

    @Override
    public long multiply(long n1, long n2) {
        return n1*n2;
    }

    @Override
    public double divide(double n1, double n2) {
        return n1/n2;
    }

}
