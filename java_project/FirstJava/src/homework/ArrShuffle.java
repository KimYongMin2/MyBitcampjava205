package homework;

import java.util.Scanner;

public class ArrShuffle {
    public static void main(String[] args) {
        int processionRow;
        int processionColumn;
        System.out.print("행(가로)수를 입력해주세요 : ");
        processionRow = getInputInt();
        System.out.print("열(세로)수를 입력해주세요 : ");
        processionColumn = getInputInt();
        int[][] score = new int[processionRow][processionColumn];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print((i+1) + "번째의 " + (j+1) + "번 수를 입력하여 주세요 : ");
                score[i][j] = getInputInt();
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
}
