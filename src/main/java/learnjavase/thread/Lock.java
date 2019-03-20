package learnjavase.thread;

/**
 * 简单锁实现
 */
public class Lock {

    //锁资源标识符
    private volatile boolean lock;

    //获取锁资源
    public synchronized void lock() throws InterruptedException {
        //如果所资源已经被其他线程占有那么就阻塞等待
        while (lock) {
            wait();
        }
        lock = true;//获得锁资源,将锁表示为已被占有
    }

    //释放锁资源
    public void unlock() {
        //释放锁资源,通知其他等待锁资源的线程
        lock = false;
        notify();
    }
}
