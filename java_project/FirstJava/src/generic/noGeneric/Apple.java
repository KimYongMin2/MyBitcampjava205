package generic.noGeneric;

public class Apple {
    int sugarContent; // 당분 함량
    public Apple(int sugar) {
        sugarContent=sugar;
    }
    public void showSugarContent()
    {
        System.out.println("당도 "+sugarContent);
    }
}
