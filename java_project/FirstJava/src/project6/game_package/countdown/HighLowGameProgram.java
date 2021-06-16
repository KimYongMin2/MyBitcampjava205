package project6.game_package.countdown;

import project6.game_package.countdown.show_countdown.ShowCount;

import javax.swing.*;

public class HighLowGameProgram implements ShowCount {
    private static boolean answerCheck = false;
    private static boolean playCheck = false;
    private static boolean timeout = false;
    private int comAnswer = 0;
    private int userAnswer = 0;

    public static boolean isAnswerCheck() {
        return answerCheck;
    }

    public static boolean isPlayCheck() {
        return playCheck;
    }

    public static void setPlayCheck(boolean playCheck) {
        HighLowGameProgram.playCheck = playCheck;
    }

    public static void setTimeout(boolean timeout) {
        HighLowGameProgram.timeout = timeout;
    }
    
    public void gamePlay() {
        while (!answerCheck) {
            try {
                if(timeout){
                    break;
                }
                setUserAnswer();
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
    }

    public void countdownThreadStart() {
        CountdownThread countdownThread = new CountdownThread();
        countdownThread.start();
    }

    public void setRandomComAnswer() {
        comAnswer = (int) (Math.random() * 100);
        showMessage("랜덤 숫자가 생성되었습니다.");
    }

    public void setStartCheck() {
        timeout = false;
        playCheck = true;
        answerCheck = false;
    }

    public void setUserAnswer() {
        String inputUserAnswer = JOptionPane.showInputDialog("정답을 입력해주세요 : ");
        userAnswer = Integer.parseInt(inputUserAnswer);
    }

    public void setGameCheck() {
        answerCheck = true;
        playCheck = false;
    }
}

