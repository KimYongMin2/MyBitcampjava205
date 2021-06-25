package bookcase;

import java.text.*;
import java.util.*;
import java.util.Date;

import bookcase.crud.*;
import bookcase.object.*;
import bookcase.show.*;
import bookcase.util.*;


public class BookRentPage extends Common implements Show {

	private static RentalCRUD rentalCrud = RentalCRUD.getInstance();
	public BookRentPage(Member member){
		this.member = member;
	}

	public void BookUsingStart() {
		while (menuButton != 2) {
			try {
				showBookUsingMenu();

				menuButton = ScannerUtil.getInputIntegerS(">> 원하시는 메뉴를 선택하세요. : ");

				switch (menuButton) {
				case 1:
					// 대여
					usingBook();
					break;
				case 2:
					// 종료
					System.out.println("[!] 전 단계로 돌아갑니다.");
					break;
				default:
					System.out.println("error : 잘못된 입력입니다.");
					break;
				}
			}catch (NumberFormatException e){
				System.out.println("error : 숫자로 입력해주세요");
			}
		}

	}


	public void usingBook(){
		// 책확인
		bookFindChk = false;
		bookList = bookCrud.getBookList(con);

		showRentalBookPage();

		bName = ScannerUtil.getInputStringS(">> 대여할 도서명을 입력해주세요 : ");

		findBook();
		
		if(bookFindChk){
			if(bookList.get(temp).getbUsing().equals("false")) {
				addUsingBook();
			} else { // bUsing = true
				System.out.println("[!] 이미 대여중인 책입니다.");
			}

		}
	}

	private void findBook() {
		for(int i = 0; i < bookList.size(); i++) {
			if(bName.equals(bookList.get(i).getbName())) {
				temp = i;
				bookFindChk = true;
			}
		}
		if(!bookFindChk) {
			System.out.println("[!] 해당 도서를 찾지 못하였습니다.");
		} else { // chk = true
			book = bookList.get(temp);
		}
	}

	public void addUsingBook() {
		// 대여리스트에 책 리스트 추가
		// 대여 날짜 오늘로 설정
		Date today = new Date();        
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String toDay = date.format(today);

		// 대여기간 1주일 기한
		Calendar week = Calendar.getInstance();
		week.add(Calendar.DATE , +7);
		String afterWeek = new java.text.SimpleDateFormat("yyMMdd").format(week.getTime());    	

		Using usingBook = new Using(0, toDay, afterWeek, member.getMemberCode(), book.getBookCode());
		book.setbUsing("true");

		rentalCrud.insertRental(con, usingBook);
		bookCrud.updateBook(con, book);
		System.out.println("[!] 대여가 완료되었습니다.");
	}
}