package myproject.myProjectThread;

public class HighLowGame {
    public static boolean check = false;
    public static void main(String[] args) {

        int comAnswer = (int)(Math.random() * 100);
        System.out.println("랜덤 숫자가 생성되었습니다.");
        CompareAnswer compareAnswer = new CompareAnswer(comAnswer);
        CountdownThread countdownThread = new CountdownThread();
        compareAnswer.start();
        countdownThread.start();
    }
}


