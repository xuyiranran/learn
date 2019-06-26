package learn_java_design.oberver_design.subject_observer;

public class ObserverApp {

    public static void main(String[] args) {

        TopicSubject topicSubject = new TopicSubject();
        AObserver aObserver = new AObserver();
        BObserver bObserver = new BObserver();

        //添加观察者
        topicSubject.registerObserver(aObserver);
        topicSubject.registerObserver(bObserver);

        //主题对象更新消息
        topicSubject.update("hello world");

    }

}
