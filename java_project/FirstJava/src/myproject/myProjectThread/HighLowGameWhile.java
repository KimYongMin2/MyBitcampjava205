package myproject.myProjectThread;

import javax.swing.*;

import common.util.ScannerUtil;

public class HighLowGameWhile {
    public static boolean answerCheck = false;
    public static boolean playCheck = false;
    public static void main(String[] args) {

        int button = 0;
        while (!(button == 2)) {
            System.out.println("----------------------");
            System.out.println("1. 게임 시작");
            System.out.println("2. 게임 종료");
            System.out.println("----------------------");
            button = ScannerUtil.getInputInteger();
            if (!playCheck) {
                switch (button) {
                    case 1:
                        playCheck = true;
                        answerCheck = false;
                        int comAnswer = (int) (Math.random() * 100);
                        System.out.println("랜덤 숫자가 생성되었습니다.");
                  ;
                        CountdownThreadWhile countdownThreadWhile = new CountdownThreadWhile();
                        countdownThreadWhile.start();
                        while (!HighLowGameWhile.answerCheck) {
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
                                HighLowGameWhile.answerCheck = true;
                                HighLowGameWhile.playCheck = false;
                            }
                        }

                        break;
                    case 2:
                        System.out.println("종료");
                        break;
                }

            }
        }
    }
}


