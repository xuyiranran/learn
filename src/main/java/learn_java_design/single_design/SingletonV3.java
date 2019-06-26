package learn_java_design.single_design;

/**
 * 通过synchronized和双重校验来防止多线程并发安全问题和性能问题.
 * 懒汉模式,延迟加载模式.
 */
public class SingletonV3 {

    private static SingletonV3 singleton;

    private SingletonV3() {
    }

    public static SingletonV3 getInstance() {
        if (singleton != null) return singleton;
        synchronized (singleton) {
            if (singleton == null) singleton = new SingletonV3();
        }
        return singleton;
    }

}
