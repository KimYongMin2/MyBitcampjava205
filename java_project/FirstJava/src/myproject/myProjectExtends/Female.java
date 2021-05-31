package myproject.myProjectExtends;

public class Female extends Person{
    private String sex = "여자";
    private boolean hasBadchim = false;

    public Female(String name, String idNumber) {
        super(name, idNumber);
    }

    void showHasBadchim(){
        System.out.println("받침이있습니까? : " + hasBadchim);
    }

    @Override
    public void hello() {
        super.hello();
        System.out.println("여자입니다.");
        showHasBadchim();
    }
}