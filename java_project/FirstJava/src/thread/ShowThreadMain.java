package thread;

public class ShowThreadMain {
    public static void main(String[] args) {
        ShowTread t1 = new ShowTread("스레드1");
        ShowTread t2 = new ShowTread("        스레드2");

        t1.start();
        t2.start();
    }
}
