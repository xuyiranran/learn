package learnData;

import java.util.concurrent.TimeUnit;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {
        Count count=new Count();
        new Thread(new TestThread(count)).start();
        new Thread(new TestThread(count)).start();
        new Thread(new TestThread(count)).start();
        new Thread(new TestThread(count)).start();

        Thread.sleep(3000);
        System.out.println(count.getCount());
    }
}
