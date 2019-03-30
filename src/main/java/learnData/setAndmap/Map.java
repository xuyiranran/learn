package learnData.setAndmap;

/**
 * 映射接口
 * 1、添加元素
 * 2、删除元素
 * 3、查询元素
 * 4、更新元素
 * 5、判断是否包含指定元素
 * 6、映射大小(键值对)
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> {

    //添加元素
    void add(K k, V v);

    //删除元素
    V remove(K k);

    //判断是否包含指定key
    boolean contains(K k);

    //查询key对应的元素
    V get(K k);

    //更新指定key的元素值
    void set(K k, V v);

    //返回大小
    int getSize();

    //判断是否为空
    boolean isEmpty();

}
