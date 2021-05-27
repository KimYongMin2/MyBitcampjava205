package ex.arrayTest;

import java.util.Scanner;

public class ArrayControl {
    ArrayInfo addArrayInfo() {
        System.out.println("------------------------------------------------");
        System.out.print("이름을 입력해주세요 : ");
        String name = getInputString();
        System.out.print("전화번호를 입력해주세요 : ");
        String telNum = getInputString();
        System.out.print("생일을 입력해주세요 : ");
        String birth = getInputString();
        ArrayMain.count++;
        return new ArrayInfo(name, telNum, birth);
    }

    void delArrayInfo(ArrayInfo[] arr){
        System.out.println("------------------------------------------------");
        System.out.print("삭제할 이름을 입력해주세요 : ");
        String name = getInputString();
        int temp=0;
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getName().equals(name)){
                temp = i;
                check = true;
                break;
            }
        }
        if (check == true) {
            for (int i = temp; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            ArrayMain.count--;
        }
        else {
            System.out.println("삭제하려는 이름을 찾지 못하였습니다.");
        }
    }

    void findArrayInfo(ArrayInfo[] arr){
        System.out.println("------------------------------------------------");
        System.out.print("찾을 이름을 입력해주세요 : ");
        String name = getInputString();
        int temp=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getName().equals(name)){
                temp = i;
                break;
            }
        }

        System.out.println("-----------------정보를 출력합니다-----------------");
        System.out.println(arr[temp].getName());
        System.out.println(arr[temp].getTelNum());
        System.out.println(arr[temp].getBirth());
    }

    void showArrayInfo(ArrayInfo[] arr){
        System.out.println("------------------현재 상황입니다------------------");
        for (int i = 0; i < ArrayMain.count; i++) {
            System.out.println((i+1) + " " +arr[i].getName());
        }
    }

    public static String getInputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
