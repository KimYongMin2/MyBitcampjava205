package project2;

import common.util.ScannerUtil;

import java.util.*;

public class SmartPhone {
    String name, phoneNum, email, address, group;
    int birth;
    int temp=0;
    boolean check = false;
    List<Contact> contacts = new ArrayList<>();

    private void findContactUser(String name) {
        temp=0;
        check = false;
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equals(name)){
                temp = i;
                check = true;
                break;
            }
        }
    }

    void addContacts(){
        lineDividing();
        System.out.println("정보를 저장합니다");
        lineDividing();
        System.out.print("이름을 입력하여 주세요 : ");
        name = ScannerUtil.getInputString();
        System.out.print("전화번호를 입력하여주세요 : ");
        phoneNum = ScannerUtil.getInputString();
        System.out.print("이메일을 입력하여주세요 : ");
        email = ScannerUtil.getInputString();
        System.out.print("주소를 입력하여주세요 : ");
        address = ScannerUtil.getInputString();
        System.out.print("생일을 입력하여주세요 : ");
        birth = ScannerUtil.getInputInteger();
        System.out.print("그룹을 입력하여주세요 : ");
        group = ScannerUtil.getInputString();
        lineDividing();
        Contact contact = new Contact(name,phoneNum, email, address, birth, group);
        contacts.add(contact);
        System.out.println("정상입력되었습니다");
    }

    void delContacts(){
        lineDividing();
        System.out.print("삭제할 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            contacts.remove(temp);
            System.out.println("삭제되었습니다");
        }
        else {
            System.out.println("삭제하려는 이름을 찾지 못하였습니다.");
            lineDividing();
        }
    }

    void showListInfo(){
        lineDividing();
        System.out.println("현재 리스트를 보여드립니다");
        lineDividing();
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i+1) + " " +contacts.get(i).getName());
        }
        System.out.println("저장된 리스트 : " + contacts.size() + "명");
    }

    void findContactInfo(){
        lineDividing();
        System.out.print("정보를 볼 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            contacts.get(temp).showContactInfo();
        }else {
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
            lineDividing();
        }
    }

    void reContacts(){
        System.out.print("수정할 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            System.out.println("수정할 이름의 정보입니다.");
            contacts.get(temp).showContactInfo();
            lineDividing();
            System.out.println("수정할 정보를 선택해주세요");
            System.out.println("1. 전화번호    2. 이메일    3. 주소    4. 생일    5. 그룹");
            System.out.print("선택 : ");
            int menu = ScannerUtil.getInputInteger();
            lineDividing();
            switch (menu){
                case 1 :
                    System.out.println("전화번호 수정");
                    System.out.print("수정할 전화번호를 입력해 주세요 : ");
                    String phoneNumber = ScannerUtil.getInputString();
                    contacts.get(temp).setNumber(phoneNumber);
                    System.out.println("완료되었습니다");
                    break;
                case 2 :
                    System.out.println("이메일 수정");
                    System.out.print("수정할 이메일을 입력해 주세요 : ");
                    String email = ScannerUtil.getInputString();
                    contacts.get(temp).setEmail(email);
                    System.out.println("완료되었습니다");
                    break;
                case 3 :
                    System.out.println("주소 수정");
                    System.out.print("수정할 주소를 입력해 주세요 : ");
                    String address = ScannerUtil.getInputString();
                    contacts.get(temp).setAddress(address);
                    System.out.println("완료되었습니다");
                    break;
                case 4 :
                    System.out.println("생일 수정");
                    System.out.print("수정할 생일을 입력해 주세요 : ");
                    int birth = ScannerUtil.getInputInteger();
                    contacts.get(temp).setBirth(birth);
                    System.out.println("완료되었습니다");
                    break;
                case 5 :
                    System.out.println("그룹 수정");
                    System.out.print("수정할 그룹 입력해 주세요 : ");
                    String group = ScannerUtil.getInputString();
                    contacts.get(temp).setGroup(group);
                    System.out.println("완료되었습니다");
                    break;
                default:
                    break;
            }
        }else {
            lineDividing();
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
        }

    }

    void lineDividing(){
        System.out.println("------------------------------------------------------------------------");
    }

}
