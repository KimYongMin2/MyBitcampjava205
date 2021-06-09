package project3;

public class CustomerContact extends Contact{
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

    public CustomerContact(String name, String number, String email, String address, int birth, String group,
                           String customerComName, String item, String job) {
        super(name, number, email, address, birth, group);
        this.customerComName = customerComName;
        this.item = item;
        this.job = job;
    }

    @Override
    public void showContactInfo() {
        super.showContactInfo();
        System.out.println("거래처 회사 이름 : " + customerComName);
        System.out.println("거래품목 : " + item);
        System.out.println("직급 :" + job);

    }
}
