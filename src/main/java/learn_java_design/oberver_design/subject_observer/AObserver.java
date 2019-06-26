package learn_java_design.oberver_design.subject_observer;

/**
 * 观察者A
 */
public class AObserver implements Observer {
    @Override
    public String curMessage(String message) {
        System.out.println("AObserver:" + message);
        return message;
    }
}
