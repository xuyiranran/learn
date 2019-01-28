package learnData.array;

/**
 * 队列数据结构接口
 * 1、enqueue()入队方法
 * 2、dequeue()出队方法
 * 3、peek()查看将要出队元素
 * 4、size()队列元素size
 * 5、isEmpty()返回队列是否为空
 */
public interface Queue<E> {

    public static final int DEFAULT_CAPACITY=10;

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 查看下一个出队元素
     * @return
     */
    E peek();

    /**
     * 返回队列size
     * @return
     */
    int size();

    /**
     * 返回队列是否为空
     * @return
     */
    boolean isEmpty();
}
