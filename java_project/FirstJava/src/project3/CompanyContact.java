package project3;

public class CompanyContact extends Contact{
    private String companyName;
    private String dept;
    private String job;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public CompanyContact(String name, String number, String email, String address, int birth, String group,
                          String companyName, String dept, String job) {
        super(name, number, email, address, birth, group);
        this.companyName = companyName;
        this.dept = dept;
        this.job = job;
    }
    @Override
    public void showContactInfo() {
        super.showContactInfo();
        System.out.println("회사이름 : " + companyName);
        System.out.println("부서이름 : " + dept);
        System.out.println("직급 :" + job);

    }
}
