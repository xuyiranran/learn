package learnjavase.thread;

/**
 * 可重入锁实现
 */
public class ReentrantLock {

    private volatile boolean lock;//锁资源占用标识
    private Thread lockThread;//当前占用锁资源线程
    private int lockTimes;//上锁次数

    public synchronized void lock() throws InterruptedException {
        //如果是同一个线程,直接让进入
        if (Thread.currentThread() == lockThread) {
            lockTimes++;
            return;
        }
        while (lock) {
            wait();
        }
        lock = true;
        lockTimes++;
        lockThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        //如果是同一个线程,直接让其进入
        if (Thread.currentThread() == lockThread) {
            lockTimes--;
        }
        if (lockTimes == 0) {
            lock = false;
            notify();
        }
    }


}
