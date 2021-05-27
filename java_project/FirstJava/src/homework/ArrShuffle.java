package homework;

import java.util.Scanner;

public class ArrShuffle {
    public static void main(String[] args) {
        int[][] score = new int[3][3];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print((i+1) + "번째의 " + (j+1) + "번 수를 입력하여 주세요 : ");
                score[i][j] = getInputScore();
            }
        }

        showInputScore(score);

        ArrShuffle(score);

        showInputScore(score);


    }
    
    private static void ArrShuffle(int[][] arr){
        int[] temp;
        for (int i = arr.length-1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
    }

    private static void showInputScore(int[][] score) {
        System.out.println("입력한 수 : ");
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getInputScore(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
