package learn_java_design.oberver_design;

public class ReaderBPressObserver implements PressObserver {
    @Override
    public String currentMessage(String message) {
        System.out.println("ReaderBPressObserver 接收到的消息:" + message);
        return message;
    }
}
