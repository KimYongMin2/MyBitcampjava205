package project3;

import common.util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class SmartPhone {
    String name, phoneNum, email, address, group, birth;
    String companyName, dept, job, customerName, item;
    int temp=0;
    boolean check = false;
    List<Contact> contacts = new ArrayList<>();

    public void findContactUser(String name) {
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

    void addContacts() throws BadIdInputException {
        lineDividing();
        System.out.println("정보를 저장합니다");
        lineDividing();
        System.out.print("이름을 입력하여 주세요 : ");
        name = ScannerUtil.getInputString();
        checkNull(name);
        checkStringKorEng(name);
        System.out.print("전화번호를 입력하여주세요 : ");
        phoneNum = ScannerUtil.getInputString();
        checkNull(phoneNum);
        checkStringNum(phoneNum);
        findSameNum(phoneNum);
        System.out.print("이메일을 입력하여주세요 : ");
        email = ScannerUtil.getInputString();
        checkNull(email);
        System.out.print("주소를 입력하여주세요 : ");
        address = ScannerUtil.getInputString();
        checkNull(address);
        System.out.print("생일을 입력하여주세요 : ");
        birth = ScannerUtil.getInputString();
        checkNull(birth);
        System.out.print("그룹을 입력하여주세요 : ");
        group = ScannerUtil.getInputString();
        checkNull(group);
        System.out.println("1. Company     2. Customer");
        System.out.print("해당사항을 선택해 주세요 : ");
        int checkCom = ScannerUtil.getInputInteger();
        switch (checkCom){
            case 1 :
                System.out.print("회사이름을 입력해주세요 : ");
                companyName = ScannerUtil.getInputString();
                checkNull(companyName);
                System.out.print("부서이름을 입력해주세요 : ");
                dept = ScannerUtil.getInputString();
                checkNull(dept);
                System.out.print("직급을 입력해주세요 : ");
                job = ScannerUtil.getInputString();
                checkNull(job);
                lineDividing();
                Contact companyContact = new CompanyContact(name,phoneNum, email, address, birth, group, companyName, dept,job);
                contacts.add(companyContact);
                System.out.println("정상입력되었습니다");
                break;
            case 2 :
                System.out.print("거래처회사이름 입력해주세요 : ");
                customerName = ScannerUtil.getInputString();
                checkNull(customerName);
                System.out.print("거래품목을 입력해주세요 : ");
                item = ScannerUtil.getInputString();
                checkNull(item);
                System.out.print("직급을 입력해주세요 : ");
                job = ScannerUtil.getInputString();
                checkNull(job);
                lineDividing();
                Contact customerContact = new CustomerContact(name,phoneNum, email, address, birth, group, customerName, item,job);
                contacts.add(customerContact);
                System.out.println("정상입력되었습니다");
                break;
            default:
                System.out.println("잘못입력하셨습니다.");
                break;
        }


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
            contacts.get(temp).showData();
        }else {
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
            lineDividing();
        }
    }

    void reContacts() throws BadIdInputException {
        boolean checkCom = false;
        System.out.print("수정할 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            System.out.println("수정할 이름의 정보입니다.");
            contacts.get(temp).showData();
            lineDividing();
            System.out.println("수정할 정보를 선택해주세요");
            if (contacts.get(temp) instanceof CompanyContact){
                System.out.println("1. 전화번호    2. 이메일    3. 주소    4. 생일    5. 그룹");
                System.out.println("6. 회사이름     7. 부서이름     8. 직급");
                checkCom = true;
            } else {
                System.out.println("1. 전화번호    2. 이메일    3. 주소    4. 생일    5. 그룹");
                System.out.println("6. 거래처회사이름     7. 거래품목     8. 직급");
                checkCom = false;
            }
            System.out.print("선택 : ");
            int menu = ScannerUtil.getInputInteger();
            if (!checkCom){
                if (menu >5){
                    menu += 3;
                }
            }
            lineDividing();
            switch (menu){
                case 1 :
                    System.out.println("전화번호 수정");
                    System.out.print("수정할 전화번호를 입력해 주세요 : ");
                    String phoneNumber = ScannerUtil.getInputString();
                    checkNull(phoneNumber);
                    checkStringNum(phoneNumber);
                    findSameNum(phoneNum);
                    contacts.get(temp).setNumber(phoneNumber);
                    System.out.println("완료되었습니다");
                    break;
                case 2 :
                    System.out.println("이메일 수정");
                    System.out.print("수정할 이메일을 입력해 주세요 : ");
                    String email = ScannerUtil.getInputString();
                    checkNull(email);
                    contacts.get(temp).setEmail(email);
                    System.out.println("완료되었습니다");
                    break;
                case 3 :
                    System.out.println("주소 수정");
                    System.out.print("수정할 주소를 입력해 주세요 : ");
                    String address = ScannerUtil.getInputString();
                    checkNull(address);
                    contacts.get(temp).setAddress(address);
                    System.out.println("완료되었습니다");
                    break;
                case 4 :
                    System.out.println("생일 수정");
                    System.out.print("수정할 생일을 입력해 주세요 : ");
                    String birth = ScannerUtil.getInputString();
                    checkNull(birth);
                    contacts.get(temp).setBirth(birth);
                    System.out.println("완료되었습니다");
                    break;
                case 5 :
                    System.out.println("그룹 수정");
                    System.out.print("수정할 그룹 입력해 주세요 : ");
                    String group = ScannerUtil.getInputString();
                    checkNull(group);
                    contacts.get(temp).setGroup(group);
                    System.out.println("완료되었습니다");
                    break;
                case 6 :
                    System.out.println("회사이름 수정");
                    System.out.print("수정할 회사이름을 입력해 주세요 : ");
                    String companyName = ScannerUtil.getInputString();
                    checkNull(companyName);
                    ((CompanyContact) contacts.get(temp)).setCompanyName(companyName);
                    System.out.println("완료되었습니다");
                    break;
                case 7 :
                    System.out.println("부서이름 수정");
                    System.out.print("수정할 부서이름을 입력해 주세요 : ");
                    String dept = ScannerUtil.getInputString();
                    checkNull(dept);
                    ((CompanyContact) contacts.get(temp)).setDept(dept);
                    System.out.println("완료되었습니다");
                    break;
                case 8 :
                    System.out.println("직급 수정");
                    System.out.print("수정할 직급을 입력해 주세요 : ");
                    String job = ScannerUtil.getInputString();
                    checkNull(job);
                    ((CompanyContact) contacts.get(temp)).setJob(job);
                    System.out.println("완료되었습니다");
                    break;
                case 9 :
                    System.out.println("거래처회사이름 수정");
                    System.out.print("수정할 거래처회사이름을 입력해 주세요 : ");
                    String customerName = ScannerUtil.getInputString();
                    checkNull(customerName);
                    ((CustomerContact) contacts.get(temp)).setCustomerComName(customerName);
                    System.out.println("완료되었습니다");
                    break;
                case 10 :
                    System.out.println("거래품목 수정");
                    System.out.print("수정할 거래품목을 입력해 주세요 : ");
                    String item = ScannerUtil.getInputString();
                    checkNull(item);
                    ((CustomerContact) contacts.get(temp)).setItem(item);
                    System.out.println("완료되었습니다");
                    break;
                case 11 :
                    System.out.println("직급 수정");
                    System.out.print("수정할 직급을 입력해 주세요 : ");
                    String job1 = ScannerUtil.getInputString();
                    checkNull(job1);
                    ((CustomerContact) contacts.get(temp)).setJob(job1);
                    System.out.println("완료되었습니다");
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
                    break;
            }
        }else {
            lineDividing();
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
        }

    }

    void checkStringKorEng(String str) throws BadIdInputException {
        for (int i = 0; i < str.length(); i++) {
            char strToChar = str.charAt(i);
            if(!((strToChar >= 'a' && strToChar <='z')||(strToChar >= 'A' && strToChar <='Z')||(strToChar>=0x1100 &&strToChar<=0x11FF))){
                throw new BadIdInputException("영어와 한글로만 입력해주세요.");
            }
        }
    }

    void checkStringNum(String str) throws BadIdInputException {
        for (int i = 0; i < str.length(); i++) {
            char strToChar = str.charAt(i);
            if(!(strToChar>='0' &&strToChar<='9')){
                throw new BadIdInputException("숫자로만 입력해주세요.");
            }
        }
    }

    void checkNull(String str) throws BadIdInputException {
        for (int i = 0; i < str.length(); i++) {
            char strToChar = str.charAt(i);
            if(strToChar == ' '){
                throw new BadIdInputException("곻백은 입력할 수 없습니다.");
            }
        }
    }

    void findSameNum(String number) throws BadIdInputException {
        temp=0;
        check = false;
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getNumber().equals(number)){
                temp = i;
                check = true;
                break;
            }
        }
        if(check) {
            throw new BadIdInputException("같은 전화번호가 있습니다.");
        }
    }

    void lineDividing(){
        System.out.println("------------------------------------------------------------------------");
    }

}
