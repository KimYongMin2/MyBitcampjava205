package project5;

import java.io.IOException;

public class ContactMain {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        int button=0;
        while (!(button==8)) {
            try {
                ShowMenu.showMainMenu();
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
                    case 6:
                        smartPhone.fileSave();
                        break;
                    case 7:
                        smartPhone.fileRead();
                        break;
                    case 8 :
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
            }catch (StringIndexOutOfBoundsException e){
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
