package learnjavase.threadpool;

public class SimpleTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "say hi");
    }
}
