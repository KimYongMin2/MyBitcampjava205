package bookcase;

import java.util.*;

import bookcase.crud.*;
import bookcase.object.*;
import bookcase.show.*;
import bookcase.util.*;

public class ReviewAddPage extends Common implements Show {

	private ReviewCRUD reviewCrud = ReviewCRUD.getInstance();
	private BookCRUD bookCrud = BookCRUD.getInstance();
	private ViewReviewCRUD viewReviewCrud = ViewReviewCRUD.getInstance();
	private ArrayList<ViewReview> viewReviews = new ArrayList<>();

	private Review review;
	private double rScore; // 별점
	private String rComment; // 한줄평

	public ReviewAddPage(Member member) {
		this.member = member;
		menuButton = 0;
	}

	public void reviewAddStart() {
		while (menuButton != 4) {
			try {
				bookList = bookCrud.getBookList(con); //오라클에서 북 테이블 전체 받음
				viewReviews = viewReviewCrud.getReviewList(con);
				showReviewAddMenu();
				menuButton = ScannerUtil.getInputIntegerS(">> 원하시는 메뉴를 선택하세요 : ");

				switch (menuButton) {
				case 1:
					reviewAdd();
					break;
				case 2:
					reviewList();
					break;
				case 3:
					bookList();
					break;
				case 4:
					System.out.println("[!] 종료합니다");
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

	private void reviewAdd() {
		bookList = bookCrud.getBookList(con);
		showReviewAdd();
		bName = ScannerUtil.getInputStringS(">> 리뷰를 작성하실 도서명을 입력하세요 : ");
		book = findBook(bookList, bName);
		bookFindChk = setFindBookCheck(book);
		if (bookFindChk) {
			addReviewComment();
		}
	}

	private void reviewList() {
		showReviewList();
		if(viewReviews.size() > 0) {
			for (int i = 0; i < viewReviews.size(); i++) {
				System.out.println(viewReviews.get(i));
			}
		} else {
			System.out.println("[!] 작성된 리뷰가 존재하지 않습니다.");
		}
	}

	private void bookList() {
		System.out.println(">> 전체 도서 목록을 출력합니다");
		System.out.println();
		bookList = bookCrud.getBookList(con);
		for (Book book : bookList) {
			System.out.println(book);
		}
	}

	public void addReviewComment() { // 리뷰입력
		setScore();
		setComment();
		review = new Review(0, member.getMemberCode(), book.getBookCode(), rScore, rComment);
		reviewCrud.insertReview(con, review);
		showReviewAddSuccess();
	}

	private void setScore() {
		showScoreMenu();
		rScore = ScannerUtil.getInputDoubleS("▶ 평점 : ");
		checkScore();
		System.out.println("[평점 입력 완료]");
	}

	private void checkScore() {
		boolean chk1 = true;
		if (rScore > 5 || rScore < 0) {
			while (chk1) {
				showScoreError();
				rScore = ScannerUtil.getInputDoubleS("▶ 평점 : ");
				if (rScore <= 5) {
					chk1 = false;
					break;
				}
			}
		}
	}

	private void setComment() {
		showCommentMenu();
		rComment = ScannerUtil.getInputStringS("▶ 한줄평 : ");
		checkComment();

		System.out.println("[한줄평 입력 완료]");
	}
	
	private void checkComment() {
		boolean chk = true;
		if (rComment.length() > 40) {
			while (chk) {
				showCommentError();
				rComment = ScannerUtil.getInputStringS("▶ 한줄평 : ");
				if (rComment.length() <= 40) {
					chk = false;
					break;
				}
			}
		}
	}


}
