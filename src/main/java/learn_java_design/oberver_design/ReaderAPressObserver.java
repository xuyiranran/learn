package learn_java_design.oberver_design;

public class ReaderAPressObserver implements PressObserver {
    @Override
    public String currentMessage(String message) {
        System.out.println("ReaderAPressObserver 接收到的消息:" + message);
        return message;
    }
}
