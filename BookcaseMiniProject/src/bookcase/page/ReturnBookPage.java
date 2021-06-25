package bookcase.page;

import java.util.*;

import bookcase.crud.BookCRUD;
import bookcase.crud.RentalCRUD;
import bookcase.object.Common;
import bookcase.object.Member;
import bookcase.object.Using;
import bookcase.show.*;
import bookcase.util.ScannerUtil;

public class ReturnBookPage extends Common implements Show {
    private static BookCRUD bookCrud = BookCRUD.getInstance();
    private static RentalCRUD rentalCrud = RentalCRUD.getInstance();
    private ArrayList<Using> usingBooks = new ArrayList<>();
    private Using use;

    public ReturnBookPage(Member member){
        this.member = member;
    }

    public void BookReturnStart() {
        while (menuButton != 2) {
            try {
                showBookReturnMenu();
                menuButton = ScannerUtil.getInputIntegerS(">> 원하시는 메뉴를 선택해주세요 : ");

                switch (menuButton) {
                    case 1:
                        // 반납
                        returnBook();
                        break;
                    case 2:
                        // 종료
                        break;
                    default:
                        System.out.println("error : 잘못된 입력입니다.");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("error : 숫자로 입력해주세요.");
            }
        }

    }


    public void returnBook(){
        bookFindChk = false;
        bookList = rentalCrud.getMyRentalList(con, member);
        usingBooks = rentalCrud.getRentalTable(con);
        showReturnBookPage();

        System.out.print(">> 반납하실 도서명을 입력하세요 : ");
        bName = ScannerUtil.getInputString();

        book = findBook(bookList, bName);
        bookFindChk = setFindBookCheck(book);

        findBookCode();

        if(!bookFindChk) {
        	System.out.println("[!] 반납실패. 다시 확인해주세요.");
        }
        else { // chk = true
            use = usingBooks.get(temp);
            checkUsingbook = setCheckUsingBook();
            if(checkUsingbook) {
                deleteUsingBook();
                System.out.println("▶ 반납이 완료되었습니다.");
            }else{
                System.out.println("[!] 반납실패. 다시 확인해주세요.");
            }
        }
    }
    
    private void findBookCode() {
    	for(int i = 0; i < usingBooks.size() ; i ++) {
    		if(book.getBookCode() == usingBooks.get(i).getBookCode()) {
    			temp =i;
                bookFindChk = true;
    		}else{
                bookFindChk = false;
            }
    	}
    }

    public void deleteUsingBook() {
        book.setbUsing("false");
        rentalCrud.ReturnMyBook(con, use);
        bookCrud.updateBook(con, book);
    }
}