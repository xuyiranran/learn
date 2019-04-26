package design.singleton_pattern;

/**
 * 单例模式(饿汉模式-通过jvm机制来保证单例)
 * 这种是最简单并安全高效的实现单例模式的方法
 */
public class SimpleSingleton {

    //实例对象
    private static final SimpleSingleton instance = new SimpleSingleton();

    //构造方法私有化
    private SimpleSingleton() {

    }

    public static SimpleSingleton getInstance() {
        return instance;
    }
}
