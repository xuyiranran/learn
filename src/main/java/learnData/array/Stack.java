package learnData.array;

import sun.jvm.hotspot.debugger.win32.coff.COMDATSelectionTypes;

/**
 * 栈数据结构
 * 1、push()入栈元素
 * 2、pop()弹出栈顶元素
 * 3、peek()查看栈顶元素
 * 4、size()查看栈元素size
 * 5、isEmpty()返回栈是否为空
 * <p>
 * Stack特点:
 * 1、只有一端操作(入栈和出栈都是在栈顶操作LILO)
 * <p>
 * Stack应用场景
 * 1、计算机系统的函数调用(指令调用)
 * 2、undo撤销操作
 * 3、实际生活中的手枪的弹匣装子弹过程
 * 经典算法题
 * 1、括号有效性校验
 *
 * 实现方式
 * 1、基于数组(普通动态数组即可)
 * 2、基于链表(只包含头节点普通链表即可)
 */
public interface Stack<E extends Comparable<E>> {

    public static final int DEFAULT_CAPACITY = 10;

    /**
     * 入栈操作
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈操作
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 查看栈元素size
     *
     * @return
     */
    int size();

    /**
     * 查看栈是否为空
     *
     * @return
     */
    boolean isEmpty();


}
