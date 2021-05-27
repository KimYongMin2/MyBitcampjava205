package homework;

import java.util.Scanner;

public class MiniMax {
    public static void main(String[] args) {
        int arrayNum;
        System.out.print("배열의 갯수를 입력해주세요 : ");
        arrayNum = getInputInt();

        int[] score = new int[arrayNum];

        for (int i = 0; i < score.length; i++) {
            System.out.print((i+1) + "번째 수를 입력하여 주세요 : ");
            score[i] = getInputInt();
        }

        showInputScore(score);

        System.out.println("가장 작은값은 : " + miniValue(score));
        System.out.println("가장 큰값은 : " +maxValue(score));

    }

    private static void showInputScore(int[] score) {
        System.out.print("입력한 수 : ");
        for (int i : score) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int miniValue(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<temp){
                temp = arr[i];
            }
        }
        return temp;
    }

    public static int maxValue(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>temp){
                temp = arr[i];
            }
        }
        return temp;
    }
    public static int getInputInt(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
