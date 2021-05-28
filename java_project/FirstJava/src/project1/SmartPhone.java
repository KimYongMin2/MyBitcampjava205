package project1;

import common.util.ScannerUtil;
import ex.arrayTest.ArrayMain;

public class SmartPhone {
    static int count;

    static {
        count = 0;
    }

    Contact[] contacts = new Contact[10];

    void addContacts(){
        System.out.println("정보를 저장합니다");
        System.out.print("이름을 입력하여 주세요 : ");
        String name = ScannerUtil.getInputString();
        System.out.print("전화번호를 입력하여주세요 : ");
        String phoneNum = ScannerUtil.getInputString();
        System.out.print("이메일을 입력하여주세요 : ");
        String email = ScannerUtil.getInputString();
        System.out.print("주소를 입력하여주세요 : ");
        String address = ScannerUtil.getInputString();
        System.out.print("생일을 입력하여주세요 : ");
        int birth = ScannerUtil.getInputInteger();
        System.out.print("그룹을 입력하여주세요 : ");
        String group = ScannerUtil.getInputString();

        Contact contact = new Contact(name,phoneNum, email, address, birth, group);
        contacts[count] = contact;
        count++;
    }

    void delContacts(){
        System.out.print("삭제할 이름을 입력해주세요 : ");
        String name = ScannerUtil.getInputString();
        int temp=0;
        boolean check = false;
        for (int i = 0; i < contacts.length; i++) {
            if(contacts[i].getName().equals(name)){
                temp = i;
                check = true;
                break;
            }
        }
        if (check == true) {
            for (int i = temp; i < contacts.length - 1; i++) {
                contacts[i] = contacts[i + 1];
            }
            count--;
        }
        else {
            System.out.println("삭제하려는 이름을 찾지 못하였습니다.");
        }
    }

    void showListInfo(){
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + " " +contacts[i].getName());
        }
    }
}
