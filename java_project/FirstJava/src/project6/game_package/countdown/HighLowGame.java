package project6.game_package.countdown;

import common.util.ScannerUtil;
import project6.game_package.countdown.show_countdown.ShowCount;

import javax.swing.*;

public class HighLowGame implements ShowCount {
    public static boolean answerCheck = false;
    public static boolean playCheck = false;
    public static boolean timeout = false;

    public HighLowGame() {
        int button = 0;
        while (!(button == 2)) {
            setGameCheck();
            showStartMenu();
            button = ScannerUtil.getInputInteger();
            if (!playCheck) {
                switch (button) {
                    case 1:
                        timeout = false;
                        playCheck = true;
                        answerCheck = false;
                        int comAnswer = (int) (Math.random() * 100);
                        System.out.println("랜덤 숫자가 생성되었습니다.");

                        CountdownThread countdownThread = new CountdownThread();
                        countdownThread.start();
                        while (!answerCheck) {
                            try {
                                if(timeout){
                                    break;
                                }
                                int userAnswer = setUserAnswer();
                                int result = comAnswer - userAnswer;
                                if (result > 0) {
                                    showMessage("up");
                                } else if (result < 0) {
                                    showMessage("down");
                                } else {
                                    showMessage("correct");
                                    showMessage("게임에서 승리하셨습니다");
                                    setGameCheck();
                                }
                            }catch (NumberFormatException e){
                                System.out.println("올바른 숫자가 아닙니다.");
                            }
                        }
                        break;
                    case 2:
                        showMessage("종료합니다");
                        break;
                }

            }
        }
    }

    private int setUserAnswer() {
        String inputUserAnswer = JOptionPane.showInputDialog("정답을 입력해주세요 : ");
        int userAnswer = Integer.parseInt(inputUserAnswer);
        return userAnswer;
    }

    private void setGameCheck() {
        answerCheck = true;
        playCheck = false;
    }
}


