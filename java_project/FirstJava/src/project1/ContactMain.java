package project1;

import common.util.ScannerUtil;

public class ContactMain {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        int button=0;
        while (!(button==6)) {
            try {
                showMenu();
                button = ScannerUtil.getInputInteger();
                switch (button) {
                    case 1:
                        smartPhone.addContacts();
                        break;
                    case 2:
                        smartPhone.delContacts();
                        break;
                    case 3:
                        smartPhone.reContacts();
                        break;
                    case 4:
                        smartPhone.showListInfo();
                        break;
                    case 5:
                        smartPhone.findContactInfo();
                        break;
                    default:
                        System.out.println("메뉴를 잘못입력하셨습니다.");
                }

            }catch (NumberFormatException e){
                System.out.println("------------------------------------------------");
                System.out.println("##### 숫자로 입력하여 주십시오 #####");
            }
        }
    }
    private static void showMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("1. 저장    2. 삭제    3. 수정    4. 리스트출력    5. 정보 검색    6. 종료");
        System.out.println("------------------------------------------------");
        System.out.print("원하는 기능을 선택해주세요 : ");
    }
}
