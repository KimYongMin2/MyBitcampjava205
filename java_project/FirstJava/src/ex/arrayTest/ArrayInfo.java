package ex.arrayTest;

public class ArrayInfo {
    private String name;
    private String telNum;
    private String birth;

    public ArrayInfo(String name, String telNum, String birth) {
        this.name = name;
        this.telNum = telNum;
        this.birth = birth;
    }

    public ArrayInfo(){
        this.name = "이름없음";
        this.telNum = "전화번호없음";
        this.birth = "생년월일없음";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

}
