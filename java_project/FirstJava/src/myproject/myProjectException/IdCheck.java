package myproject.myProjectException;

import common.util.ScannerUtil;

public class IdCheck {
    public static void main(String[] args) {
        try {
            System.out.print("ID를 입력하여주세요 :");
            String id = ScannerUtil.getInputString();
            for (int i = 0; i < id.length(); i++) {
                char idChar = id.charAt(i);
                if(!((idChar >= 'a' && idChar <='z')||(idChar >= 'A' && idChar <='Z')||(idChar>='0'&&idChar<='9'))){
                    throw new BadIdInputException("에러발생");
                }
            }
            System.out.println("ID : " + id);
            System.out.println();
        }catch (BadIdInputException e){
            System.out.println(e.getMessage());
        }
    }
}
