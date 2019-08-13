package learn_java_juc.thread_local;


public class MainApp {


    public static void main(String[] args) {

        ThreadLocalDemo threadLocalDemo=new ThreadLocalDemo();
        MyThread thread1=new MyThread(threadLocalDemo);
        MyThread thread2=new MyThread(threadLocalDemo);

        new Thread(thread1).start();
        new Thread(thread2).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocalDemo.getValue());



    }

}
