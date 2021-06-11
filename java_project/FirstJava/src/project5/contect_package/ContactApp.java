package project5.contect_package;

import project5.contect_package.show_contact.Show;
import project5.util.BadIdInputException;
import project5.util.ScannerUtil;

import java.io.IOException;

public class ContactApp implements Show {
    ContactProgram contactProgram = new ContactProgram();
    public ContactApp() {
        showFileCheck();
        int button = 0;
        while (!(button == 8)) {
            try {
                showMainMenu();
                button = ScannerUtil.getInputInteger();
                switch (button) {
                    case 1:
                        contactProgram.addContacts();
                        break;
                    case 2:
                        contactProgram.delContacts();
                        break;
                    case 3:
                        contactProgram.reContacts();
                        break;
                    case 4:
                        contactProgram.showListInfo();
                        break;
                    case 5:
                        contactProgram.findContactInfo();
                        break;
                    case 6:
                        contactProgram.fileSave();
                        break;
                    case 7:
                        contactProgram.fileRead();
                        break;
                    case 8:
                        lineDividing();
                        System.out.println("종료합니다");
                        break;
                    default:
                        System.out.println("메뉴를 잘못입력하셨습니다.");
                }

            } catch (NumberFormatException e) {
                lineDividing();
                System.out.println("##### 잘못된 입력입니다 #####");
            } catch (BadIdInputException e) {
                System.out.println(e.getMessage());
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("##### 잘못된 입력입니다 #####");
            } catch (IOException e) {
                System.out.println("입출력을 실패하였습니다.");
            } catch (ClassNotFoundException e) {
                System.out.println("파일을 찾을 수 없습니다.");
            } catch (InterruptedException e) {
                System.out.println("끝내기 오류");
            }
        }
    }

    private void showFileCheck() {
        try {
            contactProgram.fileCheck();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
