package project6.contect_package;

import project6.contect_package.construct_contact.CompanyContact;
import project6.contect_package.file_IO.ContactRead;
import project6.contect_package.file_IO.ContactWrite;
import project6.contect_package.show_contact.ShowContact;
import project6.util.BadIdInputException;
import project6.util.ScannerUtil;

import java.io.File;
import java.io.IOException;

public class ContactProgram implements ShowContact {

    String name;
    int temp=0;
    int menu;
    boolean check = false;
    ContactHandler contactHandler = new ContactHandler();

    void addContacts() throws BadIdInputException {
        showMessage("정보를 저장합니다");
        setContactInfo();
        showComOrCusCheckMenu();
        setMenuButton("해당사항을 선택해 주세요 : ");
        switch (menu){
            case 1 :
                setCompanyInfo();
                constructCom();
                break;
            case 2 :
                setCustomerInfo();
                constructCus();
                break;
            default:
                showMessage("잘못입력하였습니다");
                break;
        }
    }

    void delContacts(){
        showMessage("정보를 삭제합니다");
        setFindUserName("삭제할 이름을 입력해주세요 : ");
        findContactUser(name);
        if (check == true) {
            contactHandler.delContact(temp);
        }
        else {
            showMessage("삭제하려는 이름을 찾지 못하였습니다.");
        }
    }

    void showListInfo(){
        showMessage("현재 리스트를 보여드립니다");
        for (int i = 0; i < contactHandler.getContacts().size(); i++) {
            System.out.println((i+1) + " " + contactHandler.getContacts().get(i).getName());
        }
        System.out.println("저장된 리스트 : " + contactHandler.getContacts().size() + "명");
    }

    void findContactInfo(){
        showMessage("정보를 확인합니다");
        setFindUserName("정보를 볼 이름을 입력해주세요 : ");
        findContactUser(name);
        if (check == true) {
            showFindedUserData(temp);
        }else {
            showMessage("수정하려는 이름을 찾지 못하였습니다.");
        }
    }

    void reContacts() throws BadIdInputException {
        boolean checkComOrCus;
        showMessage("정보를 수정합니다");
        setFindUserName("수정할 이름을 입력해주세요 : ");
        findContactUser(name);
        if (check == true) {
            System.out.println("수정할 이름의 정보입니다.");
            showFindedUserData(temp);
            checkComOrCus = CheckComOrCusAndShowMenu();
            setMenuButton("수정할 정보를 선택해주세요");
            if (!checkComOrCus && menu > 5){
                menu += 3;
            }
            lineDividing();
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
                    showMessage("잘못입력하였습니다");
                    break;
            }
        }else {
            showMessage("수정하려는 이름을 찾지 못하였습니다");
        }
    }

    void fileCheck() throws InterruptedException {
        showMessage("저장된 파일이 있는지 확인합니다");
        File file = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205" +
                "\\material\\contact\\contact.txt");
        if(file.exists()){
            System.out.println("저장된 파일이 있습니다");
        }else{
            System.out.println("저장된 파일이 없습니다");
        }
    }

    void fileSave() throws InterruptedException {
        showMessage("정보를 파일로 저장합니다");
        File file = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205" +
                "\\material\\contact\\contact.txt");
        ContactWrite contactWrite = new ContactWrite(contactHandler.getContacts(), file);
        contactWrite.start();
        contactWrite.join();
    }

    void fileRead() throws IOException, ClassNotFoundException, InterruptedException {
        showMessage("저장된 정보를 불러옵니다");
        File file = new File("C:\\Users\\bitcamp\\Documents\\MyBitcampjava205" +
                "\\material\\contact\\contact.txt");
        ContactRead contactRead = new ContactRead(contactHandler.getContacts(), file);
        contactRead.start();
        contactRead.join();
        contactHandler.setContacts(contactRead.getContacts());

    }

    private void constructCus() {
        lineDividing();
        contactHandler.constructorCustomer();
        System.out.println("정상입력되었습니다");
    }

    private void constructCom() {
        lineDividing();
        contactHandler.constructorCompany();
        System.out.println("정상입력되었습니다");
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

    private void setFindUserName(String s) {
        System.out.print(s);
        name = ScannerUtil.getInputString();
        lineDividing();
    }

    private boolean CheckComOrCusAndShowMenu() {
        boolean checkComOrCus;
        if (contactHandler.getContacts().get(temp) instanceof CompanyContact){
            showComMenu();
            checkComOrCus = true;
        } else {
            showCusMenu();
            checkComOrCus = false;
        }
        return checkComOrCus;
    }

    private void showFindedUserData(int temp) {
        contactHandler.getContacts().get(temp).showData();
        lineDividing();
    }

    private void setMenuButton(String s) {
        System.out.println(s);
        System.out.print("선택 : ");
        menu = ScannerUtil.getInputInteger();
    }
}
