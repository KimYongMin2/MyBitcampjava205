package project5.contect_package.construct_contact;

public class CustomerContact extends Contact {
    private String customerComName;
    private String item;
    private String job;

    public String getCustomerComName() {
        return customerComName;
    }

    public void setCustomerComName(String customerComName) {
        this.customerComName = customerComName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public CustomerContact(String name, String number, String email, String address, String birth, String group,
                           String customerComName, String item, String job) {
        super(name, number, email, address, birth, group);
        this.customerComName = customerComName;
        this.item = item;
        this.job = job;
    }

    @Override
    public void showData() {
        System.out.println("-- Customer --");
        System.out.println("이름 : " + super.getName());
        System.out.println("번호 : " + super.getNumber());
        System.out.println("이메일 : " + super.getEmail());
        System.out.println("주소 : " + super.getAddress());
        System.out.println("생일 : " + super.getBirth());
        System.out.println("그룹 : " + super.getGroup());
        System.out.println("거래처 회사 이름 : " + customerComName);
        System.out.println("거래품목 : " + item);
        System.out.println("직급 :" + job);
    }
}

