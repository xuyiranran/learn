package design.observer_pattern;

public class BObserver implements Observer {
    @Override
    public String getNewPrice(double price) {
        String result = "BObserver 收到的股价" + price;
        System.out.println(result);
        return result;
    }
}
