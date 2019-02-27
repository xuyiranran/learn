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
public interface Set<E extends Comparable<E>> {

    int size();

    boolean isEmpty();

    void add(E e);

    void remove(E e);

    boolean contains(E e);


}
