package learnjavase.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {


    public static void main(String[] args) throws Exception{

        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(10);
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        blockingQueue.put(4);

        blockingQueue.offer(5);

        System.out.println(blockingQueue.poll());






    }
}
