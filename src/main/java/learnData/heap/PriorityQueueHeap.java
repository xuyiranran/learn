package learnData.heap;

import learnData.array.Queue;

/**
 * 基于二叉堆实现优先队列
 * 1、入队和出队操作时间复杂度都是O(log n)
 * <p>
 * 优先队列简单的实现方式可以直接使用数组或链表但是有一项操作时间复杂度必定回事O(n)
 * <p>
 * 优先队列最佳实践就是基于二叉堆(大顶堆或小顶堆)
 */
public class PriorityQueueHeap<E extends Comparable<? super E>> implements Queue<E> {

    private SimpleMaxHeap<E> simpleMaxHeap;

    public PriorityQueueHeap(int capacity) {
        simpleMaxHeap = new SimpleMaxHeap<>(capacity);
    }

    public void enqueue(E element) {
        simpleMaxHeap.add(element);
    }


    public E dequeue() {
        return simpleMaxHeap.popMax();
    }

    public E peek() {
        return simpleMaxHeap.peekMax();
    }

    public int size() {
        return simpleMaxHeap.getSize();
    }

    public boolean isEmpty() {
        return simpleMaxHeap.isEmpty();
    }


    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueueHeap<>(10);
        queue.enqueue(10);
        queue.enqueue(100);
        queue.enqueue(66);
        queue.enqueue(99);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
