package generic.noGeneric;

public class Orange {
    int sugarContent; // 당분 함량
    public Orange(int sugar) {
        sugarContent=sugar;
    }
    public void showSugarContent()
    {
        System.out.println("당도 "+sugarContent);
    }
}
