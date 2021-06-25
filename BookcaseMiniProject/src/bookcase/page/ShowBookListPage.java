package bookcase.page;

import java.util.*;

import bookcase.crud.*;
import bookcase.object.*;
import bookcase.show.*;
import bookcase.util.*;

public class ShowBookListPage extends Common implements Show {
	private static BookCRUD bookCrud  = BookCRUD.getInstance();
	private static RentalCRUD rentalCrud  = RentalCRUD.getInstance();
	private static ReturnCRUD returnCrud = ReturnCRUD.getInstance();

	private static ArrayList<Return> returns = new ArrayList<>();

	public ShowBookListPage(Member member){
		this.member = member;
	}
	public void showBookListStart() {
		while (menuButton != 4) {
			try {
				showBookListPageMenu();
				menuButton = ScannerUtil.getInputIntegerS(">> 원하시는 메뉴를 선택하세요 : ");
				
				switch (menuButton) {
					case 1:
						// 내가 대여중인 도서 보기 (반납기한도)
						showMyUsingBook(member);
						break;
					case 2:
						// 별점랭킹 추천 조회
						showStarBook();
						break;
					case 3:
						// 대여가능한 도서 조회
						showCanUsingBook();
						break;
					case 4:
						// 종료  case 6:
						System.out.println("[!] 전 단계로 돌아갑니다.");
						break;
					default:
						System.out.println("error : 잘못된 입력입니다.");
						break;
				}
			} catch (NumberFormatException e){
                System.out.println("error : 숫자로 입력해주세요");
			}
		}
	}

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
