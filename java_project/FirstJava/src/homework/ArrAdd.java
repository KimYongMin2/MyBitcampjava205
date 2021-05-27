package homework;

import java.util.Scanner;

public class ArrAdd {
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

        System.out.print("더해질 수를 입력해 주세요 : ");
        int add = getInputInt();

        addOneDArr(score, add);

        showInputScore(score);

    }

    public static void addOneDArr(int[][] arr, int add){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] += add;
            }
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

    public static int getInputInt(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
