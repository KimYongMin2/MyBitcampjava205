package myproject.myProjectThread;

import javax.swing.*;

class CompareAnswer extends Thread {
    int comAnswer;

    public CompareAnswer(int comAnswer) {
        this.comAnswer = comAnswer;
    }

    @Override
    public void run() {
        while (!HighLowGame.check) {
            String inputUserAnswer = JOptionPane.showInputDialog("정답을 입력해주세요 : ");
            int userAnswer = Integer.parseInt(inputUserAnswer);
            int result = comAnswer - userAnswer;
            if (result > 0) {
                System.out.println("up");
            } else if (result < 0) {
                System.out.println("down");
            } else {
                System.out.println("correct");
                System.out.println("게임에서 승리하셨습니다.");
                HighLowGame.check = true;
                return;
            }
        }
    }
}