package myproject.myprojectAPI;

public class TimeMeasurement {
    public static void main(String[] args) {
        long sum=0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            sum += (i+1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
