package bookcase.object;

import bookcase.crud.BookCRUD;
import bookcase.util.JDBCconnecting;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CommonObject {
    protected static Connection con = JDBCconnecting.connecting();
    protected static List<Book> bookList = new ArrayList<>();
    protected static BookCRUD bookCrud = BookCRUD.getInstance();
    protected List<Member> memberList = new ArrayList<>();
    protected int menuButton = 0;
    protected Member member;
    protected Book book;
    protected int temp = 0;
    protected boolean bookFindChk = false;
    protected int bookcode, bPrice;
    protected String bName, bWriter, bPublisher, bGenre, bAgeUsing;



}
