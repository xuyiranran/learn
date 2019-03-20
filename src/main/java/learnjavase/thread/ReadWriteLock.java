package learnjavase.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单读写锁
 */
public class ReadWriteLock {

    //读锁个数
    private int readers;
    //写锁请求
    private int requestWriters;
    //写锁标识
    private boolean writeLock;

    public synchronized void lockReadLock() throws InterruptedException {
        while (requestWriters > 0 || writeLock) {
            wait();
        }
        readers++;
    }

    public synchronized void unlockReadLock() {
        readers--;
        notifyAll();
    }

    public synchronized void lockWriteLock() throws InterruptedException {
        requestWriters++;
        while (readers > 0 || writeLock) {
            wait();
        }
        requestWriters--;
        writeLock = true;
    }

    public synchronized void unlockWriteLock() {
        writeLock = false;
        notifyAll();
    }


}
