package learnData;

public class TestThread implements Runnable {

    private Count count;
    public TestThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count.add();
        }
    }
}
