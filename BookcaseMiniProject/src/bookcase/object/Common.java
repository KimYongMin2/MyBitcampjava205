package bookcase.object;

import bookcase.crud.BookCRUD;
import bookcase.util.JDBCconnecting;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Common {
    protected static Connection con = JDBCconnecting.connecting();
    protected static List<Book> bookList = new ArrayList<>();
    protected static BookCRUD bookCrud = BookCRUD.getInstance();
    protected List<Member> memberList = new ArrayList<>();
    protected int menuButton = 0;
    protected Member member;
    protected Book book;
    protected int temp = 0;
    protected boolean bookFindChk = false;
    protected boolean checkUsingbook;
    protected int bookcode, bPrice;
    protected String bName, bWriter, bPublisher, bGenre, bAgeUsing;

    protected Book findBook(List<Book> bookList, String bName) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bName.equals(bookList.get(i).getbName())) {
                book = bookList.get(i);
            } else {
                book = null;
            }
        }
        return book;
    }

    protected boolean setFindBookCheck(Book book) {
        bookFindChk = false;
        if(book == null) {
            System.out.println("[!] 해당 도서를 찾지 못하였습니다.");
        }else {
            bookFindChk = true;
        }
        return bookFindChk;
    }

    protected boolean setCheckUsingBook() {
        if(bookFindChk){
            if(bookList.get(temp).getbUsing().equals("false")) {
                checkUsingbook = false;
            } else {
                checkUsingbook = true;
            }
        }
        return checkUsingbook;
    }


}
