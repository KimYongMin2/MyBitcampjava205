package project4;

import java.io.File;
import java.io.IOException;

public class SmartPhone {
    String name;

    int temp=0;
    boolean check = false;
    ContactHandler contactHandler = new ContactHandler();

    void addContacts() throws BadIdInputException {
        lineDividing();
        System.out.println("정보를 저장합니다");
        setContactInfo();
        ShowMenu.showComOrCus();
        int checkCom = ScannerUtil.getInputInteger();
        switch (checkCom){
            case 1 :
                setCompanyInfo();
                lineDividing();
                constructorCompany();
                System.out.println("정상입력되었습니다");
                break;
            case 2 :
                setCustomerInfo();
                lineDividing();
                constructorCustomer();
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
            contactHandler.getContacts().remove(temp);
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
        for (int i = 0; i < contactHandler.getContacts().size(); i++) {
            System.out.println((i+1) + " " + contactHandler.getContacts().get(i).getName());
        }
        System.out.println("저장된 리스트 : " + contactHandler.getContacts().size() + "명");
    }

    void findContactInfo(){
        lineDividing();
        System.out.print("정보를 볼 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            contactHandler.getContacts().get(temp).showData();
        }else {
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
            lineDividing();
        }
    }

    void reContacts() throws BadIdInputException {
        boolean checkComOrCus;
        System.out.println("수정할 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            System.out.println("수정할 이름의 정보입니다.");
            contactHandler.getContacts().get(temp).showData();
            lineDividing();
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
            lineDividing();
            switch (menu) {
                case 1 -> reNumber();
                case 2 -> reEmail();
                case 3 -> reAddress();
                case 4 -> reBirth();
                case 5 -> reGroup();
                case 6 -> reComName();
                case 7 -> reDept();
                case 8 -> reJobCom();
                case 9 -> reCustomerName();
                case 10 -> reItem();
                case 11 -> reJobCus();
                default -> System.out.println("잘못 입력하였습니다.");
            }
        }else {
            lineDividing();
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
        }

    }

    void fileSave() throws InterruptedException {
        lineDividing();
        System.out.println("파일로 저장합니다");
        File file = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205" +
                "\\material\\contact\\contact.txt");
        ContactWrite contactWrite = new ContactWrite(contactHandler.getContacts(), file);
        contactWrite.start();
        contactWrite.join();
    }

    void fileRead() throws IOException, ClassNotFoundException, InterruptedException {
        lineDividing();
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

    private void reJobCus() throws BadIdInputException {
        System.out.println("직급 수정");
        contactHandler.setJob();
        ((CustomerContact) contactHandler.getContacts().get(temp)).setJob(contactHandler.getJob());
        System.out.println("완료되었습니다");
    }

    private void reItem() throws BadIdInputException {
        System.out.println("거래품목 수정");
        contactHandler.setItem();
        ((CustomerContact) contactHandler.getContacts().get(temp)).setItem(contactHandler.getItem());
        System.out.println("완료되었습니다");
    }

    private void reCustomerName() throws BadIdInputException {
        System.out.println("거래처회사이름 수정");
        contactHandler.setCustomerName();
        ((CustomerContact) contactHandler.getContacts().get(temp)).setCustomerComName(contactHandler.getCustomerName());
        System.out.println("완료되었습니다");
    }

    private void reJobCom() throws BadIdInputException {
        System.out.println("직급 수정");
        contactHandler.setJob();
        ((CompanyContact) contactHandler.getContacts().get(temp)).setJob(contactHandler.getJob());
        System.out.println("완료되었습니다");
    }

    private void reDept() throws BadIdInputException {
        System.out.println("부서이름 수정");
        contactHandler.setDept();
        ((CompanyContact) contactHandler.getContacts().get(temp)).setDept(contactHandler.getDept());
        System.out.println("완료되었습니다");
    }

    private void reComName() throws BadIdInputException {
        System.out.println("회사이름 수정");
        contactHandler.setComName();
        ((CompanyContact) contactHandler.getContacts().get(temp)).setCompanyName(contactHandler.getCompanyName());
        System.out.println("완료되었습니다");
    }

    private void reGroup() throws BadIdInputException {
        System.out.println("그룹 수정");
        contactHandler.setGroup();
        contactHandler.getContacts().get(temp).setGroup(contactHandler.getGroup());
        System.out.println("완료되었습니다");
    }

    private void reBirth() throws BadIdInputException {
        System.out.println("생일 수정");
        contactHandler.setBirth();
        contactHandler.getContacts().get(temp).setBirth(contactHandler.getBirth());
        System.out.println("완료되었습니다");
    }

    private void reAddress() throws BadIdInputException {
        System.out.println("주소 수정");
        contactHandler.setAddress();
        contactHandler.getContacts().get(temp).setAddress(contactHandler.getAddress());
        System.out.println("완료되었습니다");
    }

    private void reEmail() throws BadIdInputException {
        System.out.println("Email 수정");
        contactHandler.setEmail();
        contactHandler.getContacts().get(temp).setEmail(contactHandler.getEmail());
        System.out.println("완료되었습니다");
    }

    private void reNumber() throws BadIdInputException {
        System.out.println("번호 수정");
        contactHandler.setNumber();
        contactHandler.getContacts().get(temp).setNumber(contactHandler.getNumber());
        System.out.println("완료되었습니다");
    }

    private void constructorCustomer() {
        Contact customerContact = new CompanyContact(contactHandler.getName(), contactHandler.getNumber(),
                contactHandler.getEmail(), contactHandler.getAddress(), contactHandler.getBirth(),
                contactHandler.getGroup(), contactHandler.getCustomerName(), contactHandler.getItem(), contactHandler.getJob());
        contactHandler.getContacts().add(customerContact);
    }

    private void constructorCompany() {
        Contact companyContact = new CompanyContact(contactHandler.getName(), contactHandler.getNumber(),
                contactHandler.getEmail(), contactHandler.getAddress(), contactHandler.getBirth(),
                contactHandler.getGroup(), contactHandler.getCompanyName(), contactHandler.getDept(), contactHandler.getJob());
        contactHandler.getContacts().add(companyContact);
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
        lineDividing();
        contactHandler.setName();
        contactHandler.setNumber();
        contactHandler.setEmail();
        contactHandler.setAddress();
        contactHandler.setBirth();
        contactHandler.setGroup();
    }

    void lineDividing(){
        System.out.println("------------------------------------------------------------------------");
    }
}
