package design.observer_pattern;

public class AObserver implements Observer {
    @Override
    public String getNewPrice(double price) {
        String result = "AObserver 收到的股价" + price;
        System.out.println(result);
        return result;
    }
}
