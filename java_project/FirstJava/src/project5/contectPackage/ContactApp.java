package project5.contectPackage;

import project5.contectPackage.UserInterface.ShowMenu;
import project5.utilAndException.BadIdInputException;
import project5.utilAndException.Line;
import project5.utilAndException.ScannerUtil;

import java.io.IOException;

public class ContactApp {
    ContactProgram contactProgram = new ContactProgram();
    public ContactApp() {
        int button = 0;
        while (!(button == 8)) {
            try {
                ShowMenu.showMainMenu();
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
                        Line.lineDividing();
                        System.out.println("종료합니다");
                        break;
                    default:
                        System.out.println("메뉴를 잘못입력하셨습니다.");
                }

            } catch (NumberFormatException e) {
                Line.lineDividing();
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
}
