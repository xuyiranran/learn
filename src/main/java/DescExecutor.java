import java.util.concurrent.Callable;

public class DescExecutor implements Callable<ServiceOrder> {

    private ServiceOrder serviceOrder;

    public DescExecutor(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public ServiceOrder call() throws Exception {
        Thread.sleep(1000);
        serviceOrder.setDesc(Thread.currentThread().getName() + "setDesc");
        return serviceOrder;
    }
}
