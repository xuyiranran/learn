package learn_java_design.oberver_design.subject_observer;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 主题对象,可以理解为书刊杂志社、报刊、早晨牛奶提供商
 */
public class TopicSubject {

    //主题对象
    private String message;

    //订阅主题的对象集合
    private Set<Observer> observers = Sets.newHashSet();

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    //更新主题对象状态
    public void update(String message) {
        setMessage(message);
        notifyAllObservers(message);
    }

    //注册观察者对象
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    //删除观察者对象
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    //通知所有订阅对象(观察者)
    public void notifyAllObservers(Object object) {
        for (Observer observer : observers) {
            observer.curMessage((String) object);
        }
    }
}
