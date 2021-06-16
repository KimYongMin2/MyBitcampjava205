package project6;

import project6.contect_package.ContactApp;
import project6.game_package.countdown.HighLowGameWhile;
import project6.util.ScannerUtil;

public class SmartPhone {
    int menu = 0;
    public SmartPhone() {
            while (!(menu == 3)) {
                    System.out.println("1. 연락처     2. 카운트다운     3. 종료");
                    System.out.print("원하시는 서비스를 선택해주세요 : ");
                    menu = ScannerUtil.getInputInteger();
                    switch (menu) {
                            case 1:
                                    System.out.println("연락처");
                                    new ContactApp();
                                    break;
                            case 2:
                                    System.out.println("카운트다운");
                                    new HighLowGameWhile();
                                    break;
                            case 3:
                                    System.out.println("종료합니다");
                                    break;
                    }
            }
    }
}
