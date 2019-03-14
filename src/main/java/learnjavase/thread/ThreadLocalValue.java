package learnjavase.thread;

import java.util.Random;

public class ThreadLocalValue implements Runnable{

    private ThreadLocal<String> stringThreadLocal=new ThreadLocal<>();

    @Override
    public void run() {

        int value= (int) (Math.random()*100);
        stringThreadLocal.set(value+"");
        System.out.println(Thread.currentThread().getName()+"--->"+stringThreadLocal.get());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName()+"--->"+value);
    }

    public static void main(String[] args) {

        ThreadLocalValue threadLocalValue=new ThreadLocalValue();
        new Thread(threadLocalValue).start();
        new Thread(threadLocalValue).start();
        new Thread(threadLocalValue).start();


    }
}
