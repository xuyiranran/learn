import java.util.concurrent.Callable;

public class AgeExecutor implements Callable<ServiceOrder> {

    private ServiceOrder serviceOrder;

    public AgeExecutor(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public ServiceOrder call() throws Exception {
        Thread.sleep(1000);
        serviceOrder.setAge(20);
        return serviceOrder;
    }
}
