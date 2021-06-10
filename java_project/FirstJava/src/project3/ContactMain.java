package project3;

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
                    case 6 :
                        smartPhone.lineDividing();
                        System.out.println("종료합니다");
                        break;
                    default:
                        System.out.println("메뉴를 잘못입력하셨습니다.");
                }

            }catch (NumberFormatException e){
                smartPhone.lineDividing();
                System.out.println("##### 잘못된 입력입니다 #####");
            }catch (BadIdInputException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private static void showMenu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. 저장    2. 삭제    3. 수정");
        System.out.println("4. 리스트출력    5. 정보 검색    6. 종료");
        System.out.println("------------------------------------------------------------------------");
        System.out.print("원하는 기능을 선택해주세요 : ");
    }
}
