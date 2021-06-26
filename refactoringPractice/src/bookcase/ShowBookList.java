package bookcase;

import java.util.*;

import bookcase.crud.*;
import bookcase.object.*;
import bookcase.util.*;

public class ShowBookList extends Common {

	private BookCRUD bookCrud  = BookCRUD.getInstance();
	private RentalCRUD rentalCrud  = RentalCRUD.getInstance();
	private ReturnCRUD returnCrud = ReturnCRUD.getInstance();

	private ArrayList<Return> returns = new ArrayList<>();

	public void showMyUsingBook(Member member){ //내가 대여한 도서 목록, 반납기한 보기
		returns = returnCrud.getReturnList(con, member);
		if (returns.isEmpty()) { // 수정 : 리스트 비어있는지 확인
			System.out.println("[!] 현재 대여중인 도서가 없습니다.");
		} else {
			System.out.println("현재 대여중인 도서 목록입니다.");
			for(Return returnit : returns) {
				System.out.println(returnit);
			}
		}
	}

	public void showStarBook(){
		bookList = bookCrud.getBestBookList(con);
		System.out.println("■■■■■■■■■■■ 랭    킹 ■■■■■■■■■■■");
		if(bookList.isEmpty()) {
			System.out.println(">> 랭킹이 존재하지 않습니다.");
		} else {
			for(int i = 0 ; i < bookList.size() ; i ++) {
				System.out.println("▶ 순 위 : "+(i+1)+"위");
				System.out.println("▶ 도서명 : "+bookList.get(i).getbName());
			}
		}
	}

	public void showCanUsingBook(){
		bookList = rentalCrud.getPossibleList(con);

		if(bookList.isEmpty()) {
			System.out.println("[!] 대여가능한 도서가 없습니다");
		} else {
			for(Book book:bookList) {
				System.out.println();
				System.out.println(book);
				System.out.println();
			}
		}
	}
}
