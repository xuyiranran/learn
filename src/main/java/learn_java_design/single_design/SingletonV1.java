package learn_java_design.single_design;

/**
 * 并发场景下存在线程安全问题
 * 懒汉模式,延迟加载模式.
 */
public class SingletonV1 {

    private static SingletonV1 singleton;

    private SingletonV1() {
    }

    public static SingletonV1 getInstance() {
        if (singleton == null) {
            singleton = new SingletonV1();
        }
        return singleton;
    }

}
