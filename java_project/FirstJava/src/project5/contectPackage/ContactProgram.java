package project5.contectPackage;

import project5.UserInterface.ShowMenu;
import project5.contectPackage.CompanyContact;
import project5.contectPackage.ContactHandler;
import project5.fileHandler.ContactRead;
import project5.fileHandler.ContactWrite;
import project5.utilAndException.BadIdInputException;
import project5.utilAndException.ScannerUtil;
import project5.utilAndException.Line;


import java.io.File;
import java.io.IOException;

public class ContactProgram {

    String name;
    int temp=0;
    boolean check = false;
    ContactHandler contactHandler = new ContactHandler();

    void addContacts() throws BadIdInputException {
        Line.lineDividing();
        System.out.println("정보를 저장합니다");
        Line.lineDividing();
        setContactInfo();
        ShowMenu.showComOrCus();
        int checkCom = ScannerUtil.getInputInteger();
        switch (checkCom){
            case 1 :
                setCompanyInfo();
                Line.lineDividing();
                contactHandler.constructorCompany();
                System.out.println("정상입력되었습니다");
                break;
            case 2 :
                setCustomerInfo();
                Line.lineDividing();
                contactHandler.constructorCustomer();
                System.out.println("정상입력되었습니다");
                break;
            default:
                System.out.println("잘못입력하셨습니다.");
                break;
        }


    }

    void delContacts(){
        Line.lineDividing();
        System.out.print("삭제할 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        Line.lineDividing();
        findContactUser(name);
        if (check == true) {
            contactHandler.getContacts().remove(temp);
            System.out.println("삭제되었습니다");
        }
        else {
            System.out.println("삭제하려는 이름을 찾지 못하였습니다.");
            Line.lineDividing();
        }
    }

    void showListInfo(){
        Line.lineDividing();
        System.out.println("현재 리스트를 보여드립니다");
        Line.lineDividing();
        for (int i = 0; i < contactHandler.getContacts().size(); i++) {
            System.out.println((i+1) + " " + contactHandler.getContacts().get(i).getName());
        }
        System.out.println("저장된 리스트 : " + contactHandler.getContacts().size() + "명");
    }

    void findContactInfo(){
        Line.lineDividing();
        System.out.print("정보를 볼 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        Line.lineDividing();
        findContactUser(name);
        if (check == true) {
            contactHandler.getContacts().get(temp).showData();
        }else {
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
            Line.lineDividing();
        }
    }

    void reContacts() throws BadIdInputException {
        boolean checkComOrCus;
        System.out.print("수정할 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        Line.lineDividing();
        findContactUser(name);
        if (check == true) {
            System.out.println("수정할 이름의 정보입니다.");
            contactHandler.getContacts().get(temp).showData();
            Line.lineDividing();
            System.out.println("수정할 정보를 선택해주세요");
            if (contactHandler.getContacts().get(temp) instanceof CompanyContact){
                ShowMenu.showComMenu();
                checkComOrCus = true;
            } else {
                ShowMenu.showCusMenu();
                checkComOrCus = false;
            }
            System.out.print("선택 : ");
            int menu = ScannerUtil.getInputInteger();
            if (!checkComOrCus){
                if (menu >5){
                    menu += 3;
                }
            }
            Line.lineDividing();
            switch (menu) {
                case 1:
                    contactHandler.reNumber(temp);
                    break;
                case 2:
                    contactHandler.reEmail(temp);
                    break;
                case 3:
                    contactHandler.reAddress(temp);
                    break;
                case 4:
                    contactHandler.reBirth(temp);
                    break;
                case 5:
                    contactHandler.reGroup(temp);
                    break;
                case 6:
                    contactHandler.reComName(temp);
                    break;
                case 7:
                    contactHandler.reDept(temp);
                    break;
                case 8:
                    contactHandler.reJobCom(temp);
                    break;
                case 9:
                    contactHandler.reCustomerName(temp);
                    break;
                case 10:
                    contactHandler.reItem(temp);
                    break;
                case 11:
                    contactHandler.reJobCus(temp);
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
                    break;
            }
        }else {
            Line.lineDividing();
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
        }
    }

    void fileSave() throws InterruptedException {
        Line.lineDividing();
        System.out.println("파일로 저장합니다");
        File file = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205" +
                "\\material\\contact\\contact.txt");
        ContactWrite contactWrite = new ContactWrite(contactHandler.getContacts(), file);
        contactWrite.start();
        contactWrite.join();
    }

    void fileRead() throws IOException, ClassNotFoundException, InterruptedException {
        Line.lineDividing();
        System.out.println("파일을 불러옵니다");
        File file = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205" +
                "\\material\\contact\\contact.txt");
        ContactRead contactRead = new ContactRead(contactHandler.getContacts(), file);
        contactRead.start();
        contactRead.join();
        contactHandler.setContacts(contactRead.getContacts());

    }

    public void findContactUser(String name) {
        temp=0;
        check = false;
        for (int i = 0; i < contactHandler.getContacts().size(); i++) {
            if(contactHandler.getContacts().get(i).getName().equals(name)){
                temp = i;
                check = true;
                break;
            }
        }
    }

    private void setCustomerInfo() throws BadIdInputException {
        contactHandler.setCustomerName();
        contactHandler.setItem();
        contactHandler.setJob();
    }

    private void setCompanyInfo() throws BadIdInputException {
        contactHandler.setComName();
        contactHandler.setDept();
        contactHandler.setJob();
    }

    private void setContactInfo() throws BadIdInputException {
        contactHandler.setName();
        contactHandler.setNumber();
        contactHandler.setEmail();
        contactHandler.setAddress();
        contactHandler.setBirth();
        contactHandler.setGroup();
    }

}
