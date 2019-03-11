package learnjavase.thread;

public class ProcessThread extends Thread {

    //线程暂停标识,不直接使用Thread的stop方法
    private boolean stop = false;
    public synchronized void setStop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            //do something
        }
    }
}
