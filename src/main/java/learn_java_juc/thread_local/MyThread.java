package learn_java_juc.thread_local;

public class MyThread implements Runnable{

    private ThreadLocalDemo threadLocalDemo;

    public MyThread(ThreadLocalDemo threadLocalDemo){
        this.threadLocalDemo=threadLocalDemo;
    }

    @Override
    public void run() {
        threadLocalDemo.setValue(Thread.currentThread().getName()+"value");
        System.out.println(threadLocalDemo.getValue());
    }
}
