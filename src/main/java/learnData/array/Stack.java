package learnData.array;

/**
 * 栈数据结构
 * 1、push()入栈元素
 * 2、pop()弹出栈顶元素
 * 3、peek()查看栈顶元素
 * 4、size()查看栈元素size
 * 5、isEmpty()返回栈是否为空
 */
public interface Stack<E> {

    public static final int DEFAULT_CAPACITY=10;

    /**
     * 入栈操作
     * @param e
     */
    void push(E e);

    /**
     * 出栈操作
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();

    /**
     * 查看栈元素size
     * @return
     */
    int size();

    /**
     * 查看栈是否为空
     * @return
     */
    boolean isEmpty();


}
