package learnData.setAndmap;

/**
 * 集合接口定义(不包含重复元素)
 * 1、size、isEmpty属性
 * 2、add(E e)
 * 3、remove(E e)
 * 4、contains(E e)
 *
 * @param <E>
 */
public interface Set<E> {

    //集合大小
    int size();

    //集合是否为空
    boolean isEmpty();

    //添加元素到集合
    void add(E e);

    //删除集合中某个元素
    void remove(E e);

    //判断集合中是否包含某个元素
    boolean contains(E e);

}
