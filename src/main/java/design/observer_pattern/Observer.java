package design.observer_pattern;

/**
 * 证券实时股价发布订阅模式
 */
public interface Observer {

    String getNewPrice(double price);

}
