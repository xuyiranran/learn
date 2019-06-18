package design.observer_pattern;

public class ObserverApp {

    public static void main(String[] args) {

        Subject subject = new Subject();
        Observer aObserver = new AObserver();
        Observer bObserver = new BObserver();
        subject.registerObserver(aObserver);
        subject.registerObserver(bObserver);

        subject.notifyAllObservers(12);
        System.out.println("-------");
        subject.unregisterObserver(aObserver);
        subject.notifyAllObservers(11);

    }
}
