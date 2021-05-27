package ex.arrayTest;

import java.util.Scanner;

public class ArrayMain {
    private static void arrayInfoFirstset(ArrayInfo[] arrayInfo) {
        for (int i = 0; i < arrayInfo.length; i++) {
            arrayInfo[i] = new ArrayInfo();
        }
    }
    static int count = 0;
    public static void main(String[] args) {
        ArrayControl arrayControl = new ArrayControl();
        ArrayInfo[] arrayInfo = new ArrayInfo[100];
        arrayInfoFirstset(arrayInfo);

        int button=0;
        while (!(button==5)) {
            System.out.println("1. 저장    2. 삭제    3. 검색  4. 출력   5. 종료");
            System.out.print("원하는 기능을 선택해주세요 : ");
            button = Integer.parseInt(getInputString());
            switch (button) {
                case 1:
                    arrayInfo[count] = arrayControl.addArrayInfo();
                    break;
                case 2:
                    arrayControl.delArrayInfo(arrayInfo);
                    break;
                case 3:
                    arrayControl.findArrayInfo(arrayInfo);
                    break;
                case 4 :
                    arrayControl.showArrayInfo(arrayInfo);
                default:
                    break;
            }

        }

    }

    public static String getInputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
