package graph;

import java.util.concurrent.Callable;

public class NameProcess implements Callable<Order> {

    private Order order;
    public NameProcess(Order order){
        this.order=order;
    }
    @Override
    public Order call() throws Exception {
        order.setName("name");
        return order;
    }
}
