package project6.contect_package.show_contact;

public interface ShowContact {
     default void showComOrCusCheckMenu() {
        System.out.println("1. Company     2. Customer");
    }

    default void showCusMenu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. 전화번호    2. 이메일    3. 주소    4. 생일    5. 그룹");
        System.out.println("6. 거래처회사이름     7. 거래품목     8. 직급");
        System.out.println("------------------------------------------------------------------------");
    }

    default void showComMenu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. 전화번호    2. 이메일    3. 주소    4. 생일    5. 그룹");
        System.out.println("6. 회사이름     7. 부서이름     8. 직급");
        System.out.println("------------------------------------------------------------------------");
    }

    default void showMainMenu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. 저장    2. 삭제    3. 수정");
        System.out.println("4. 리스트출력    5. 정보 검색");
        System.out.println("6. 파일 저장     7. 파일 불러오기");
        System.out.println("8. 종료");
        System.out.println("------------------------------------------------------------------------");
        System.out.print("원하는 기능을 선택해주세요 : ");
    }

    default void showMessage(String s) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(s);
        System.out.println("------------------------------------------------------------------------");
    }

    default void lineDividing(){
        System.out.println("------------------------------------------------------------------------");
    }

    default void showFileSaveMenu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("파일을 덮어씌우시겠습니까?");
        System.out.println("1. 네     2. 아니오");
        System.out.println("------------------------------------------------------------------------");
    }

    default void showFileReadMenu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("현재 저장된 파일이 지워지고 덮어씌워집니다");
        System.out.println("1. 네     2. 아니오");
        System.out.println("------------------------------------------------------------------------");

    }
}
