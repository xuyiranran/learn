package design.observer_pattern;

import com.google.common.collect.Lists;

import java.util.List;

public class Subject {

    private double price;
    private List<Observer> observers = Lists.newArrayList();


    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updatePrice(double price) {
        if (this.price != price) {
            notifyAllObservers(price);
        }
    }


    public void notifyAllObservers(double price) {

        for (Observer observer : observers) {
            observer.getNewPrice(price);
        }

    }


}
