package graph;

import java.util.concurrent.Callable;

public class IDProcess implements Callable<Order> {

    private Order order;
    public IDProcess(Order order){
        this.order=order;
    }
    @Override
    public Order call() throws Exception {
        order.setId(10);
        return order;
    }
}
