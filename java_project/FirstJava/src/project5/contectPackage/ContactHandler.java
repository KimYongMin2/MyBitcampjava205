package project5.contectPackage;

import project5.contectPackage.construct.construct.CompanyContact;
import project5.contectPackage.construct.construct.Contact;
import project5.contectPackage.construct.construct.CustomerContact;
import project5.utilAndException.BadIdInputException;
import project5.utilAndException.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class ContactHandler {
    private String name, number, email, address, group, birth;
    private String companyName, dept, job, customerName, item;
    private int temp=0;
    private boolean check = false;
    private List<Contact> contacts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() {
        return group;
    }

    public String getBirth() {
        return birth;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDept() {
        return dept;
    }

    public String getJob() {
        return job;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItem() {
        return item;
    }

    public int getTemp() {
        return temp;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setItem() throws BadIdInputException {
        System.out.print("거래품목을 입력해주세요 : ");
        String item = ScannerUtil.getInputString();
        checkNull(item);
        this.item = item;
    }

    public void setCustomerName() throws BadIdInputException {
        System.out.print("거래처회사이름 입력해주세요 : ");
        String customerName = ScannerUtil.getInputString();
        checkNull(customerName);
        this.customerName = customerName;
    }

    public void setJob() throws BadIdInputException {
        System.out.print("직급을 입력해주세요 : ");
        String job = ScannerUtil.getInputString();
        checkNull(job);
        this.job = job;
    }

    public void setDept() throws BadIdInputException {
        System.out.print("부서이름을 입력해주세요 : ");
        String dept = ScannerUtil.getInputString();
        checkNull(dept);
        this.dept = dept;
    }

    public void setComName() throws BadIdInputException {
        System.out.print("회사이름을 입력해주세요 : ");
        String companyName = ScannerUtil.getInputString();
        checkNull(companyName);
        this.companyName = companyName;
    }

    public void setGroup() throws BadIdInputException {
        System.out.print("그룹을 입력하여주세요 : ");
        String group = ScannerUtil.getInputString();
        checkNull(group);
        this.group = group;
    }

    public void setBirth() throws BadIdInputException {
        System.out.print("생일을 입력하여주세요 : ");
        String birth = ScannerUtil.getInputString();
        checkNull(birth);
        this.birth = birth;
    }

    public void setAddress() throws BadIdInputException {
        System.out.print("주소를 입력하여주세요 : ");
        String address = ScannerUtil.getInputString();
        checkNull(address);
        this.address = address;
    }

    public void setEmail() throws BadIdInputException {
        System.out.print("이메일을 입력하여주세요 : ");
        String email = ScannerUtil.getInputString();
        checkNull(email);
        this.email = email;
    }

    public void setNumber() throws BadIdInputException {
        System.out.println("전화번호를 입력하여주세요");
        System.out.println("000-0000-0000");
        System.out.print("전화번호 : ");
        String number = ScannerUtil.getInputString();
        checkNull(number);
        findSameNum(number);
        checkNumberForm(number);
        this.number = number;
    }

    public void setName() throws BadIdInputException {
        System.out.print("이름을 입력하여 주세요 : ");
        String name = ScannerUtil.getInputString();
        checkNull(name);
        checkStringKorEng(name);
        this.name = name;
    }

    void checkStringKorEng(String str) throws BadIdInputException {
        for (int i = 0; i < str.length(); i++) {
            char strToChar = str.charAt(i);
            if(!((strToChar >= 'a' && strToChar <='z')||(strToChar >= 'A' && strToChar <='Z')
                    ||(strToChar>='가' &&strToChar<='힣')||(strToChar>='ㄱ' &&strToChar<='ㅎ'))){
                throw new BadIdInputException("영어와 한글로만 입력해주세요.");
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

    void checkNumberForm(String str) throws BadIdInputException,StringIndexOutOfBoundsException {
        String numberForm = "000-0000-0000";
        if(!(numberForm.charAt(3) == str.charAt(3) && numberForm.charAt(8) == str.charAt(8)
                && str.length() == 13)){
            throw new BadIdInputException("전화번호 형식이 올바르지 않습니다.");
        }
        for (int i = 0; i < str.length(); i++) {
            char strToChar = str.charAt(i);
            if(!(i == 3 || i == 8)) {
                if (!(strToChar >= '0' && strToChar <= '9')) {
                    throw new BadIdInputException("숫자로만 입력해주세요.");
                }
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

    public void constructorCustomer() {
        Contact customerContact = new CompanyContact(name, number, email, address, birth, group, customerName, item, job);
        contacts.add(customerContact);
    }

    public void constructorCompany() {
        Contact companyContact = new CompanyContact(name, number, email, address, birth, group, companyName, dept, job);
        contacts.add(companyContact);
    }

    public void reJobCus(int temp) throws BadIdInputException {
        System.out.println("직급 수정");
        setJob();
        ((CustomerContact) contacts.get(temp)).setJob(job);
        System.out.println("완료되었습니다");
    }

    public void reItem(int temp) throws BadIdInputException {
        System.out.println("거래품목 수정");
        setItem();
        ((CustomerContact) contacts.get(temp)).setItem(item);
        System.out.println("완료되었습니다");
    }

    public void reCustomerName(int temp) throws BadIdInputException {
        System.out.println("거래처회사이름 수정");
        setCustomerName();
        ((CustomerContact) contacts.get(temp)).setCustomerComName(customerName);
        System.out.println("완료되었습니다");
    }

    public void reJobCom(int temp) throws BadIdInputException {
        System.out.println("직급 수정");
        setJob();
        ((CompanyContact) contacts.get(temp)).setJob(job);
        System.out.println("완료되었습니다");
    }

    public void reDept(int temp) throws BadIdInputException {
        System.out.println("부서이름 수정");
        setDept();
        ((CompanyContact) contacts.get(temp)).setDept(dept);
        System.out.println("완료되었습니다");
    }

    public void reComName(int temp) throws BadIdInputException {
        System.out.println("회사이름 수정");
        setComName();
        ((CompanyContact) contacts.get(temp)).setCompanyName(companyName);
        System.out.println("완료되었습니다");
    }

    public void reGroup(int temp) throws BadIdInputException {
        System.out.println("그룹 수정");
        setGroup();
        contacts.get(temp).setGroup(group);
        System.out.println("완료되었습니다");
    }

    public void reBirth(int temp) throws BadIdInputException {
        System.out.println("생일 수정");
        setBirth();
        contacts.get(temp).setBirth(birth);
        System.out.println("완료되었습니다");
    }

    public void reAddress(int temp) throws BadIdInputException {
        System.out.println("주소 수정");
        setAddress();
        contacts.get(temp).setAddress(address);
        System.out.println("완료되었습니다");
    }

    public void reEmail(int temp) throws BadIdInputException {
        System.out.println("Email 수정");
        setEmail();
        contacts.get(temp).setEmail(email);
        System.out.println("완료되었습니다");
    }

    public void reNumber(int temp) throws BadIdInputException {
        System.out.println("번호 수정");
        setNumber();
        contacts.get(temp).setNumber(number);
        System.out.println("완료되었습니다");
    }
}
