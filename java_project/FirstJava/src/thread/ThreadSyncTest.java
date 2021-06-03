package thread;

public class ThreadSyncTest {
    public static void main(String[] args) {
        Increment increment = new Increment();
        IncThread incThread1 = new IncThread(increment);
        IncThread incThread2 = new IncThread(increment);
        IncThread incThread3 = new IncThread(increment);

        incThread1.start();
        incThread2.start();
        incThread3.start();

        try {
            incThread1.join();
            incThread2.join();
            incThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(increment.getNum());

    }
}

class Increment {
    int num = 0;

    public synchronized void increment(){
        num++;
    }
    public int getNum(){
        return num;
    }
}

class IncThread extends Thread{
    Increment increment;

    IncThread(Increment increment){
        this.increment = increment;
    }

    public void run(){
        for (int i = 0; i < 10000; i++) {
            increment.increment();
        }
    }

}
