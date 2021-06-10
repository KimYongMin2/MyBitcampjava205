package project4;

import java.io.File;
import java.io.IOException;

public class SmartPhone {
    String name;

    int temp=0;
    boolean check = false;
    InputSet inputSet = new InputSet();

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
            inputSet.getContacts().remove(temp);
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
        for (int i = 0; i < inputSet.getContacts().size(); i++) {
            System.out.println((i+1) + " " + inputSet.getContacts().get(i).getName());
        }
        System.out.println("저장된 리스트 : " + inputSet.getContacts().size() + "명");
    }

    void findContactInfo(){
        lineDividing();
        System.out.print("정보를 볼 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            inputSet.getContacts().get(temp).showData();
        }else {
            System.out.println("수정하려는 이름을 찾지 못하였습니다.");
            lineDividing();
        }
    }

    void reContacts() throws BadIdInputException {
        boolean checkCom;
        System.out.println("수정할 이름을 입력해주세요 : ");
        name = ScannerUtil.getInputString();
        lineDividing();
        findContactUser(name);
        if (check == true) {
            System.out.println("수정할 이름의 정보입니다.");
            inputSet.getContacts().get(temp).showData();
            lineDividing();
            System.out.println("수정할 정보를 선택해주세요");
            if (inputSet.getContacts().get(temp) instanceof CompanyContact){
                ShowMenu.showComMenu();
                checkCom = true;
            } else {
                ShowMenu.showCusMenu();
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
        ContactWrite contactWrite = new ContactWrite(inputSet.getContacts(), file);
        contactWrite.start();
        contactWrite.join();
    }

    void fileRead() throws IOException, ClassNotFoundException, InterruptedException {
        lineDividing();
        System.out.println("파일을 불러옵니다");
        File file = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205" +
                "\\material\\contact\\contact.txt");
        ContactRead contactRead = new ContactRead(inputSet.getContacts(), file);
        contactRead.start();
        contactRead.join();
        inputSet.setContacts(contactRead.getContacts());

    }

    public void findContactUser(String name) {
        temp=0;
        check = false;
        for (int i = 0; i < inputSet.getContacts().size(); i++) {
            if(inputSet.getContacts().get(i).getName().equals(name)){
                temp = i;
                check = true;
                break;
            }
        }
    }

    private void reJobCus() throws BadIdInputException {
        System.out.println("직급 수정");
        inputSet.setJob();
        ((CustomerContact) inputSet.getContacts().get(temp)).setJob(inputSet.getJob());
        System.out.println("완료되었습니다");
    }

    private void reItem() throws BadIdInputException {
        System.out.println("거래품목 수정");
        inputSet.setItem();
        ((CustomerContact)inputSet.getContacts().get(temp)).setItem(inputSet.getItem());
        System.out.println("완료되었습니다");
    }

    private void reCustomerName() throws BadIdInputException {
        System.out.println("거래처회사이름 수정");
        inputSet.setCustomerName();
        ((CustomerContact) inputSet.getContacts().get(temp)).setCustomerComName(inputSet.getCustomerName());
        System.out.println("완료되었습니다");
    }

    private void reJobCom() throws BadIdInputException {
        System.out.println("직급 수정");
        inputSet.setJob();
        ((CompanyContact) inputSet.getContacts().get(temp)).setJob(inputSet.getJob());
        System.out.println("완료되었습니다");
    }

    private void reDept() throws BadIdInputException {
        System.out.println("부서이름 수정");
        inputSet.setDept();
        ((CompanyContact) inputSet.getContacts().get(temp)).setDept(inputSet.getDept());
        System.out.println("완료되었습니다");
    }

    private void reComName() throws BadIdInputException {
        System.out.println("회사이름 수정");
        inputSet.setComName();
        ((CompanyContact) inputSet.getContacts().get(temp)).setCompanyName(inputSet.getCompanyName());
        System.out.println("완료되었습니다");
    }

    private void reGroup() throws BadIdInputException {
        System.out.println("그룹 수정");
        inputSet.setGroup();
        inputSet.getContacts().get(temp).setGroup(inputSet.getGroup());
        System.out.println("완료되었습니다");
    }

    private void reBirth() throws BadIdInputException {
        System.out.println("생일 수정");
        inputSet.setBirth();
        inputSet.getContacts().get(temp).setBirth(inputSet.getBirth());
        System.out.println("완료되었습니다");
    }

    private void reAddress() throws BadIdInputException {
        System.out.println("주소 수정");
        inputSet.setAddress();
        inputSet.getContacts().get(temp).setAddress(inputSet.getAddress());
        System.out.println("완료되었습니다");
    }

    private void reEmail() throws BadIdInputException {
        System.out.println("Email 수정");
        inputSet.setEmail();
        inputSet.getContacts().get(temp).setEmail(inputSet.getEmail());
        System.out.println("완료되었습니다");
    }

    private void reNumber() throws BadIdInputException {
        System.out.println("번호 수정");
        inputSet.setNumber();
        inputSet.getContacts().get(temp).setNumber(inputSet.getNumber());
        System.out.println("완료되었습니다");
    }

    private void constructorCustomer() {
        Contact customerContact = new CompanyContact(inputSet.getName(),inputSet.getNumber(),
                inputSet.getEmail(), inputSet.getAddress(), inputSet.getBirth(),
                inputSet.getGroup(), inputSet.getCustomerName(), inputSet.getItem(),inputSet.getJob());
        inputSet.getContacts().add(customerContact);
    }

    private void constructorCompany() {
        Contact companyContact = new CompanyContact(inputSet.getName(),inputSet.getNumber(),
                inputSet.getEmail(), inputSet.getAddress(), inputSet.getBirth(),
                inputSet.getGroup(), inputSet.getCompanyName(), inputSet.getDept(),inputSet.getJob());
        inputSet.getContacts().add(companyContact);
    }

    private void setCustomerInfo() throws BadIdInputException {
        inputSet.setCustomerName();
        inputSet.setItem();
        inputSet.setJob();
    }

    private void setCompanyInfo() throws BadIdInputException {
        inputSet.setComName();
        inputSet.setDept();
        inputSet.setJob();
    }

    private void setContactInfo() throws BadIdInputException {
        lineDividing();
        inputSet.setName();
        inputSet.setNumber();
        inputSet.setEmail();
        inputSet.setAddress();
        inputSet.setBirth();
        inputSet.setGroup();
    }

    void lineDividing(){
        System.out.println("------------------------------------------------------------------------");
    }
}
