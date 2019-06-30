package learn_data_structure.queue_stack;

/**
 * 队列数据结构接口
 * 1、enqueue()入队方法
 * 2、dequeue()出队方法
 * 3、peek()查看将要出队元素
 * 4、size()队列元素size
 * 5、isEmpty()返回队列是否为空
 *
 * 队列数据结构,先进先出FIFO
 * 对应于数组的操作是入队是addLast,出队是getFirst
 * [front===========tail]
 *
 * 队列数据结构特点
 * 1、队尾入队,队首出队(FIFO)
 *
 * 队列应用场景
 * 1、和实际生活中的场景比较类似
 * 2、线程池队请求任务的排队请求策略
 * 3、生产者消费者模式
 *
 * 实现方式
 * 1、基于数组(头尾指针数组)
 * 2、基于链表(头尾节点链表)
 */
public interface Queue {


    //入队操作
    void enqueue(int element);

    //出队操作
    int dequeue();

    //查看下一个出队元素
    int peek();

    //返回队列大小
    int size();

    //查看队列是否为空
    boolean isEmpty();

}
