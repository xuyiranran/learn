package design.singleton_pattern;

/**
 * 单例模式(懒汉模式-延迟加载)
 */
public class UnsafeLazySingleton {

    //实例对象
    private static UnsafeLazySingleton instance = null;

    //私有化构造方法
    private UnsafeLazySingleton() {

    }

    //获取实例对象的方法
    public static UnsafeLazySingleton getInstance() {
        //存在多线程并发问题
        if (instance == null) {
            instance = new UnsafeLazySingleton();
        }
        return instance;
    }


}
