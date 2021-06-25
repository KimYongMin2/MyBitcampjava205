package bookcase;

import java.sql.*;
import java.util.*;

import bookcase.crud.*;
import bookcase.object.*;
import bookcase.show.*;
import bookcase.util.*;

public class ReturnBook implements Show {

    private Connection con = JDBCconnecting.connecting();
    private RentalCRUD rentalCrud = RentalCRUD.getInstance();
    private BookCRUD bookCrud = BookCRUD.getInstance();
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Using> usingBooks = new ArrayList<>();
   
    private boolean chk = false;
    private Member member;
    private Book book;
    private Using use;
    private int temp = 0;
    private int temp2 = 0;
    private int bookcode=0;
    private String bName;

    public ReturnBook(Member member){
        this.member = member;
    }

    public void returnBook() {
        // 책확인
        chk = false;
        bookList = rentalCrud.getMyRentalList(con, member);
        usingBooks = rentalCrud.getRentalTable(con);
        showReturnBookPage();

        System.out.print(">> 반납하실 도서명을 입력하세요 : ");
        bName = ScannerUtil.getInputString();

        findBook();
        findBookCode();

        if(!chk) {
        	System.out.println("[!] 반납실패. 다시 확인해주세요.");
        }
        else { // chk = true
            book = bookList.get(temp);
            use = usingBooks.get(temp2);
            if(book.getbUsing().equals("true")) {
                deleteUsingBook();
                System.out.println("▶ 반납이 완료되었습니다.");
            }else{
                System.out.println("[!] 반납실패. 다시 확인해주세요.");
            }
        }
    }

    private void findBook() {
        for(int i = 0; i < bookList.size(); i++) {
            if(bName.equals(bookList.get(i).getbName())) {
                temp = i;
                chk = true;
            }
        }
    }
    
    private void findBookCode() {
    	for(int i = 0; i < usingBooks.size() ; i ++) {
    		if(bookcode == usingBooks.get(i).getBookCode()) {
    			temp2 =i;
    		}
    	}
    }

    public void deleteUsingBook() {
        book.setbUsing("false");
        rentalCrud.ReturnMyBook(con, use);
        bookCrud.updateBook(con, book);
    }
}