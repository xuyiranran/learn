package learn_java_design.single_design;

/**
 * 如果不要求懒加载实现单例模式,这种方法将会是最简单高效的方式。
 * <p>
 * 饿汉模式,立刻加载模式.
 */
public class Singleton {

    //类加载的时候就初始化实例对象
    private static final Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }

}
