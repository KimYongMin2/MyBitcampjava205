package project1;

import common.util.ScannerUtil;

public class SmartPhone {
    private static int count;
    int temp=0;
    boolean check = false;
    static {
        count = 0;
    }
    Contact[] contacts = new Contact[10];
    SmartPhone(){
        for (int i = 0; i < contacts.length; i++) {
            Contact contact = new Contact("미입력", "미입력", "미입력", "미입력", 000, "미입력");
            contacts[i] = contact;
        }
    }

    private void findContactUser(String name) {
        temp=0;
        check = false;
        for (int i = 0; i < contacts.length; i++) {
            if(contacts[i].getName().equals(name)){
                temp = i;
                check = true;
                break;
            }
        }
    }

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
        findContactUser(name);
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
    void findContactInfo(){
        System.out.print("정보를 볼 이름을 입력해주세요 : ");
        String name = ScannerUtil.getInputString();
        findContactUser(name);
        if (check == true) {
            contacts[temp].showContactInfo();
        }else {
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
        }
    }

    void reContacts(){
        System.out.print("수정할 이름을 입력해주세요 : ");
        String name = ScannerUtil.getInputString();
        findContactUser(name);
        if (check == true) {
            System.out.println("수정할 정보를 선택해주세요");
            System.out.println("1. 전화번호    2. 이메일    3. 주소    4. 생일    5. 그룹");
            System.out.print("선택 : ");
            int menu = ScannerUtil.getInputInteger();
            switch (menu){
                case 1 :
                    System.out.println("전화번호 수정");
                    System.out.print("수정할 전화번호를 입력해 주세요 : ");
                    String phoneNumber = ScannerUtil.getInputString();
                    contacts[temp].setNumber(phoneNumber);
                    System.out.println("완료되었습니다");
                    break;
                case 2 :
                    System.out.println("이메일 수정");
                    System.out.print("수정할 이메일을 입력해 주세요 : ");
                    String email = ScannerUtil.getInputString();
                    contacts[temp].setNumber(email);
                    System.out.println("완료되었습니다");
                    break;
                case 3 :
                    System.out.println("주소 수정");
                    System.out.print("수정할 주소를 입력해 주세요 : ");
                    String address = ScannerUtil.getInputString();
                    contacts[temp].setNumber(address);
                    System.out.println("완료되었습니다");
                    break;
                case 4 :
                    System.out.println("생일 수정");
                    System.out.print("수정할 생일을 입력해 주세요 : ");
                    String birth = ScannerUtil.getInputString();
                    contacts[temp].setNumber(birth);
                    System.out.println("완료되었습니다");
                    break;
                case 5 :
                    System.out.println("그룹 수정");
                    System.out.print("수정할 그룹 입력해 주세요 : ");
                    String group = ScannerUtil.getInputString();
                    contacts[temp].setNumber(group);
                    System.out.println("완료되었습니다");
                    break;
                default:
                    break;
            }
        }else {
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
        }

    }

}
