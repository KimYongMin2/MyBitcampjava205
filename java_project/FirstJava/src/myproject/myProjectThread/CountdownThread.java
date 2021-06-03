package myproject.myProjectThread;

public class CountdownThread extends Thread{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            if(HighLowGame.check) {
                return;
            }
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("10초가 지나 게임에서 졌습니다.");
        System.exit(0);
    }
}
