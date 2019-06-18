package design.observer_pattern.jdkobserver;

import java.util.Observable;

public class SubObservable extends Observable {

    private String message;

    public SubObservable(String message){
        this.message=message;
    }

    public void setMessage(String message) {
        this.message=message;
        setChanged();
        notifyObservers();
    }
}
