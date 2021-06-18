package project5;

import project5.contect_package.ContactApp;
import project5.util.ScannerUtil;

public class SmartPhone {
        int menu = 0;
        public SmartPhone() {
        }
        public void phoneStart(){
            while (!(menu == 2)) {
                    System.out.println("1. 연락처     2. 종료");
                    System.out.print("원하시는 서비스를 선택해주세요 : ");
                    menu = ScannerUtil.getInputInteger();
                    switch (menu) {
                            case 1:
                                    System.out.println("연락처");
                                    ContactApp contactApp = new ContactApp();
                                    contactApp.contactAppStart();
                                    break;
                            case 2:
                                    System.out.println("종료합니다");
                                    break;
                    }
            }
    }
}
