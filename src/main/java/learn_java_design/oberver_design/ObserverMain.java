package learn_java_design.oberver_design;

public class ObserverMain {

    public static void main(String[] args) {

        PressSubject pressSubject = new PressSubject();
        ReaderAPressObserver readerAPressObserver = new ReaderAPressObserver();
        ReaderBPressObserver readerBPressObserver = new ReaderBPressObserver();
        ReaderCPressObserver readerCPressObserver = new ReaderCPressObserver();


        pressSubject.registerObserver(readerAPressObserver);
        pressSubject.registerObserver(readerBPressObserver);
        pressSubject.registerObserver(readerCPressObserver);

        pressSubject.updateMessage("hello");

    }

}
