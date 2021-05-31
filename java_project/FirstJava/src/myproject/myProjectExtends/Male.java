package myproject.myProjectExtends;

public class Male extends Person{
    private String sex = "남자";
    private boolean hasBadchim = true;

    public Male(String name, String idNumber) {
        super(name, idNumber);
    }

    void showHasBadchim(){
        System.out.println("받침이있습니까? : " + hasBadchim);
    }

    @Override
    public void hello() {
        super.hello();
        System.out.println("남자입니다.");
        showHasBadchim();
    }
}
