package learn_java_design.single_design;

/**
 * 通过synchronized关键字解决并发场景下的线程安全问题,并发量较大时性能不是很好.
 * 懒汉模式,延迟加载模式.
 */
public class SingletonV2 {

    private static SingletonV2 singleton;

    private SingletonV2() {
    }

    public static synchronized SingletonV2 getInstance() {
        if (singleton == null) {
            singleton = new SingletonV2();
        }
        return singleton;
    }

}
