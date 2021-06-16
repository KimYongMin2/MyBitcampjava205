package project6.game_package.countdown;

import project6.game_package.countdown.show_countdown.ShowCount;

public class CountdownThread extends Thread implements ShowCount {

    @Override
    public void run() {
        for (int i = 20; i > 0; i--) {
            if(HighLowGameProgram.isAnswerCheck()) {
                HighLowGameProgram.setPlayCheck(false);
                return;
            }
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                HighLowGameProgram.setPlayCheck(false);
                e.printStackTrace();
            }
        }
        showMessage("20초가 지나 게임에서 패배하였습니다.");
        HighLowGameProgram.setTimeout(true);
    }
}
