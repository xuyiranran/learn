package design.singleton_pattern;

/**
 * 单例模式(懒汉模式-延迟加载)
 * 通过synchronized方法消除并发实现单例模式
 */
public class SafeLazySlowSingleton {

    //实例对象
    private static SafeLazySlowSingleton instance = null;

    //私有化构造方法
    private SafeLazySlowSingleton() {

    }

    //获取实例对象的方法
    public static synchronized SafeLazySlowSingleton getInstance() {
        //消除的了多线程问题但改方法存在性能瓶颈
        if (instance == null) {
            instance = new SafeLazySlowSingleton();
        }
        return instance;
    }


}
