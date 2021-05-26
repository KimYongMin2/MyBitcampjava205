package myProjectExtends;

public class Female extends Person{
    private String sex = "여자";
    private boolean hasCouple = false;

    public Female(String name, String idNumber) {
        super(name, idNumber);
    }

    void showCouple(){
        System.out.println("커플입니까?" + hasCouple);
    }

    @Override
    public void hello() {
        super.hello();
        System.out.println("여자입니다.");
        showCouple();
    }

}