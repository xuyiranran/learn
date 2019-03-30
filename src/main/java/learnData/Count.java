package learnData;

public class Count {

    private volatile int count;

    public int add() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count++;
    }

    public int getCount() {
        return count;
    }
}
