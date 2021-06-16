package project6.game_package.countdown;

import project6.game_package.countdown.show_countdown.ShowCount;

public class CountdownThreadWhile extends Thread implements ShowCount {

    @Override
    public void run() {
        for (int i = 20; i > 0; i--) {
            if(HighLowGameWhile.answerCheck) {
                HighLowGameWhile.playCheck = false;
                return;
            }
            System.out.println(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                HighLowGameWhile.playCheck = false;
                e.printStackTrace();
            }
        }
        showMessage("20초가 지나 게임에서 패배하였습니다.");
        HighLowGameWhile.timeout = true;
    }
}
