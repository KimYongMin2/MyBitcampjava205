package project6.game_package.countdown;

import common.util.ScannerUtil;
import project6.game_package.countdown.show_countdown.ShowCount;

public class HighLowGameApp implements ShowCount {
    HighLowGameProgram highLowGameProgram = new HighLowGameProgram();
    private int button = 0;

    public HighLowGameApp() {
        while (!(button == 2)) {
            try {
                highLowGameProgram.setGameCheck();
                showStartMenu();
                button = ScannerUtil.getInputInteger();
            }catch (NumberFormatException e){
                showMessage("숫자로 입력해주세요");
            }
            if (!HighLowGameProgram.isPlayCheck()) {
                switch (button) {
                    case 1:
                        highLowGameProgram.setStartCheck();
                        highLowGameProgram.setRandomComAnswer();
                        highLowGameProgram.countdownThreadStart();
                        highLowGameProgram.gamePlay();
                        break;
                    case 2:
                        showMessage("종료합니다");
                        break;
                }

            }
        }
    }
}

