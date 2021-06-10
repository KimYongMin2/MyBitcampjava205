package project5.contectPackage;

public class CompanyContact extends Contact {
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

    public CompanyContact(String name, String number, String email, String address, String birth, String group,
                          String companyName, String dept, String job) {
        super(name, number, email, address, birth, group);
        this.companyName = companyName;
        this.dept = dept;
        this.job = job;
    }


    @Override
    public void showData() {
        System.out.println("-- Company --");
        System.out.println("이름 : " + super.getName());
        System.out.println("번호 : " + super.getNumber());
        System.out.println("이메일 : " + super.getEmail());
        System.out.println("주소 : " + super.getAddress());
        System.out.println("생일 : " + super.getBirth());
        System.out.println("그룹 : " + super.getGroup());
        System.out.println("회사이름 : " + companyName);
        System.out.println("부서이름 : " + dept);
        System.out.println("직급 :" + job);
    }
}

