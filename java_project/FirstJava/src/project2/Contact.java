package project2;

public class Contact {
    private String name;
    private String number;
    private String email;
    private String address;
    private int birth;
    private String group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Contact(String name, String number, String email, String address, int birth, String group) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.group = group;
    }

    public void showContactInfo(){
        System.out.println("이름 : " + name);
        System.out.println("번호 : " + number);
        System.out.println("이메일 : " + email);
        System.out.println("주소 : " + address);
        System.out.println("생일 : " + birth);
        System.out.println("그룹 : " + group);
    }


}
