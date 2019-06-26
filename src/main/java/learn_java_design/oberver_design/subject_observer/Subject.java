package learn_java_design.oberver_design.subject_observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyAllObservers(Object object);

}
