package learn_java_design.oberver_design;

import com.google.common.collect.Sets;

import java.util.Set;

public class PressSubject {
    private String msg;

    private Set<PressObserver> pressObservers = Sets.newHashSet();

    public void registerObserver(PressObserver pressObserver) {
        pressObservers.add(pressObserver);
    }

    public void removeObserver(PressObserver pressObserver) {
        pressObservers.remove(pressObserver);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void updateMessage(String message) {
        setMsg(message);
        notifyAll(message);
    }

    public void notifyAll(String message) {
        if (!pressObservers.isEmpty()) {
            for (PressObserver pressObserver : pressObservers) {
                pressObserver.getMessage(message);
            }
        }
    }

}
