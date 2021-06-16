package project6.game_package.countdown.show_countdown;

public interface ShowCount {
    default void showStartMenu() {
        System.out.println("----------------------");
        System.out.println("1. 게임 시작");
        System.out.println("2. 게임 종료");
        System.out.println("----------------------");
    }

    default void showMessage(String s) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(s);
        System.out.println("------------------------------------------------------------------------");
    }
}
