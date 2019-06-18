package graph;

import java.util.concurrent.*;

public class CurrTest {


    public static void main(String[] args) {

        ExecutorService executorService=Executors.newFixedThreadPool(3);

        Order order=new Order();
        IDProcess idProcess=new IDProcess(order);
        NameProcess nameProcess=new NameProcess(order);
        Future<Order> future=executorService.submit(idProcess);
        executorService.submit(nameProcess);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(order.toString());

        executorService.shutdown();

    }
}
