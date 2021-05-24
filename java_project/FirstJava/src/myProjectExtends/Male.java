package myProjectExtends;

public class Male extends Person{
    String sex = "남자";
    boolean hasCouple = false;

    public Male(String name, String idNumber) {
        super(name, idNumber);
    }

    void showCouple(){
        System.out.println("커플입니까?" + hasCouple);
    }

    @Override
    public void hello() {
        super.hello();
        System.out.println("남자입니다.");
        showCouple();
    }

}
