package homework;

import java.util.Scanner;

public class ArrShuffle {

    private static int[][] setProcess() {
        System.out.print("행(가로)수를 입력해주세요 : ");
        int processionRow = getInputInt();
        System.out.print("열(세로)수를 입력해주세요 : ");
        int processionColumn = getInputInt();
        int[][] score = new int[processionRow][processionColumn];
        return score;
    }

    private static void setProcessScore(int[][] score) {
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print((i + 1) + "번째의 " + (j + 1) + "번 수를 입력하여 주세요 : ");
                score[i][j] = getInputInt();
            }
        }
    }

    private static void ArrShuffle(int[][] arr){
        for (int i = arr.length-1; i > 0; i--) {
            int[] temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
    }

    private static void showInputScore(int[][] score) {
        System.out.println("현재상황 : ");
        for (int[] ints : score) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int getInputInt(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        int[][] score = setProcess();
        setProcessScore(score);
        showInputScore(score);
        System.out.println("순서를 바꿉니다.");
        ArrShuffle(score);
        showInputScore(score);
    }


}
