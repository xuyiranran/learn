package learnData;

public class Counter {

    private int count;
    private static int sum;

    public int addCount1(int value) {
        synchronized (this) {
            count += value;
        }
        return count;
    }

    public synchronized int addCount2(int value) {
        count = count + value;
        return count;
    }

    public static synchronized int addSum1(int value) {
        sum = sum + value;
        return sum;
    }

    public static synchronized int addSum2(int value) {
        synchronized (Counter.class) {
            sum = sum + value;
        }
        return sum;
    }

}
