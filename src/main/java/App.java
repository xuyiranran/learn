import com.google.common.collect.Lists;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(30);
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setId(1);

        NameExecutor nameExecutor = new NameExecutor(serviceOrder);
        AgeExecutor ageExecutor = new AgeExecutor(serviceOrder);
        DescExecutor descExecutor = new DescExecutor(serviceOrder);

//        Future<ServiceOrder> nameFuture = executorService.submit(nameExecutor);
//        Future<ServiceOrder> descFuture = executorService.submit(descExecutor);
//        Future<ServiceOrder> ageFuture = executorService.submit(ageExecutor);

        System.out.println(System.currentTimeMillis()/1000);
        executorService.invokeAll(Lists.newArrayList(nameExecutor,ageExecutor,descExecutor),3, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(serviceOrder);

        executorService.shutdown();



    }
}
