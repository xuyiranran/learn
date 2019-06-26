package learn_java_design.oberver_design.subject_observer;

/**
 * 观察者B
 */
public class BObserver implements Observer {
    @Override
    public String curMessage(String message) {
        System.out.println("BObserver:" + message);
        return message;
    }
}
