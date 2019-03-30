package learnjavase.thread;

import java.util.HashMap;
import java.util.Map;

public class ReentrantLockReadWriteLock {


    //读锁个数
    private int readers;
    //写请求个数
    private int requestWriters;

    //写锁上锁次数
    private int writeLockTimes;

    //读线程可能存在多个
    private Map<Thread, Integer> threadIntegerMap = new HashMap<>();
    //写线程始终只能有一个
    private Thread writeThread;


    public synchronized void lockReadLock() throws InterruptedException {
        Thread cur = Thread.currentThread();
        if (threadIntegerMap.containsKey(cur)) {
            threadIntegerMap.put(cur, threadIntegerMap.get(cur) + 1);
            return;
        }
        while (requestWriters > 0 || writeLockTimes > 0) {
            wait();
        }
        threadIntegerMap.put(cur, 1);
        readers++;
    }

    public synchronized void unlockReadLock() {
        Thread cur = Thread.currentThread();
        if (threadIntegerMap.containsKey(cur)) {
            threadIntegerMap.put(cur, threadIntegerMap.get(cur) - 1);
        }
        if (threadIntegerMap.get(cur) == 0) {
            threadIntegerMap.remove(cur);
            readers--;
            notifyAll();
        }
    }

    public synchronized void lockWriteLock() throws InterruptedException {

        if (Thread.currentThread() == writeThread) {
            writeLockTimes++;
            return;
        }
        requestWriters++;
        while (readers > 0 || writeLockTimes > 0) {
            wait();
        }
        requestWriters--;
        writeLockTimes++;
        writeThread = Thread.currentThread();
    }

    public synchronized void unlockWriteLock() {

        if (Thread.currentThread() == writeThread) {
            writeLockTimes--;
        }
        if (writeLockTimes == 0) {
            writeThread = null;
            notifyAll();
        }
    }

}
