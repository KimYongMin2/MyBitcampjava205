package thread;

public class RunnableThread {
    public static void main(String[] args) {
        AdderThread at1 = new AdderThread(1,50);
        AdderThread at2 = new AdderThread(51,100);

        Thread t1 = new Thread(at1);
        Thread t2 = new Thread(at2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(at1.getNum() + at2.getNum());
    }
}

class Sum {
    int num;

    public void addNum(int n){
        num += n;
    }

    public int getNum(){
        return num;
    }
}

class AdderThread extends Sum implements Runnable {
    int startNum;
    int endNum;

    public AdderThread(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public void run() {
        for (int i = startNum; i <= endNum; i++) {
            addNum(i);
        }
    }
}