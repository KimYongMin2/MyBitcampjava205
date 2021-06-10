package project3;

import java.io.Serializable;

public abstract class Contact implements ShowData, Serializable {
    private String name;
    private String number;
    private String email;
    private String address;
    private String birth;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Contact(String name, String number, String email, String address, String birth, String group) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.group = group;
    }
}
