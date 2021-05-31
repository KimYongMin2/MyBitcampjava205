package myproject.myprojectAPI;

import common.util.ScannerUtil;

public class nameCheck {
    //사용자에게 이름을 입력 받아 입력 받은문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고,
    // 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.
    public static void main(String[] args){
        System.out.print("이름을 입력하여 주세요 : ");
        String name = ScannerUtil.getInputString();
        boolean checkNull = false;
        if (!(name.isEmpty())) {
            for (int i = 0; i < name.length(); i++) {
                char n = name.charAt(i);
                if (n == ' ') {
                    checkNull = true;
                }
            }
            if(checkNull == true){
                System.out.println("이름에 공백란이 있습니다.");
            }else{
                System.out.println(name);
            }
        }else{
            System.out.println("이름을 입력하지 않았습니다.");
        }

    }
}
