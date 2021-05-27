package homework;

import java.util.Scanner;

public class ArrAdd {

    private static void setProcessScore(int[][] score) {
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print((i+1) + "번째의 " + (j+1) + "번 수를 입력하여 주세요 : ");
                score[i][j] = getInputInt();
            }
        }
    }

    private static int[][] setProcess() {
        System.out.print("행(가로)수를 입력해주세요 : ");
        int processionRow = getInputInt();
        System.out.print("열(세로)수를 입력해주세요 : ");
        int processionColumn = getInputInt();
        int[][] score = new int[processionRow][processionColumn];
        return score;
    }

    public static void addOneDArr(int[][] arr, int add){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] += add;
            }
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
        System.out.print("더해질 수를 입력해 주세요 : ");
        int add = getInputInt();
        addOneDArr(score, add);
        showInputScore(score);

    }
}
