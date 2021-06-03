package myproject.myProjectThread;

public class CountdownThreadWhile extends Thread{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            if(HighLowGameWhile.answerCheck) {
                HighLowGameWhile.playCheck = false;
                return;
            }
            System.out.println(i);
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                HighLowGameWhile.playCheck = false;
                e.printStackTrace();
            }
        }
        System.out.println("10초가 지나 게임에서 졌습니다.");
        System.exit(0);
    }
}
