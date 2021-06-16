package project6.util;

import java.util.Scanner;

public class ScannerUtil {
    static Scanner scanner;
    public static String getInputString(){
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInputInteger(){
        scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static char getInputChar(){
        scanner = new Scanner(System.in);
        return scanner.nextLine().charAt(0);
    }
}
