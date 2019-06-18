import java.util.concurrent.Callable;

public class NameExecutor implements Callable<ServiceOrder> {

    private ServiceOrder serviceOrder;

    public NameExecutor(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public ServiceOrder call() throws Exception {
        Thread.sleep(1000);
        serviceOrder.setName(Thread.currentThread().getName() + "setName");
        return serviceOrder;
    }
}
