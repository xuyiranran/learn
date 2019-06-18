package learnjavase.threadpool;

import java.util.concurrent.Callable;

public class CallTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}
