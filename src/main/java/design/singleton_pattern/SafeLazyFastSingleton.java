package design.singleton_pattern;

/**
 * 单例模式(懒汉模式-延迟加载)
 * 通过双重校验实现单例模式
 */
public class SafeLazyFastSingleton {

    //实例对象
    private static SafeLazyFastSingleton instance = null;

    //私有化构造方法
    private SafeLazyFastSingleton() {

    }

    //获取实例对象的方法
    public static SafeLazyFastSingleton getInstance() {
        //通过双重校验消除的了多线程问题,并且性能问题也解决了.
        if (instance == null) {
            synchronized (SafeLazyFastSingleton.class) {
                if (instance == null) {
                    instance = new SafeLazyFastSingleton();
                }
            }
        }
        return instance;
    }


}
