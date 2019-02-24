package learnData.heap;

import learnData.array.Queue;

/**
 * 基于数组实现优先队列
 * 1、入队操作为O(1)复杂度
 * 2、出队操作为O(n)复杂度
 *
 * @param <E>
 */
public class PriorityQueueArray<E extends Comparable<? super E>> implements Queue<E> {

    private E[] data;
    private int size;

    public PriorityQueueArray(int capcity) {
        data = (E[]) new Comparable[capcity];
    }

    public PriorityQueueArray() {
        data = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(E e) {
        data[size] = e;
        size++;
        if (size == data.length) {
            ensureCapcity(2 * size + 1);
        }
    }

    @Override
    public E dequeue() {
        if (size == 0) throw new RuntimeException("空");
        E max = data[0];
        int maxIndex = 0;
        //寻找到最大元素
        for (int i = 0; i < size; i++) {
            if (max.compareTo(data[i]) < 0) {
                max = data[i];
                maxIndex = i;
            }
        }
        //删除最大元素
        for (int i = maxIndex; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return max;

    }

    @Override
    public E peek() {
        if (size == 0) throw new RuntimeException("空");
        E max = data[0];
        for (int i = 0; i < size; i++) {
            if (max.compareTo(data[i]) < 0) {
                max = data[i];
            }
        }
        return max;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 扩容和缩容
     *
     * @param newCapcity
     */
    private void ensureCapcity(int newCapcity) {
        E[] newData = (E[]) new Comparable[newCapcity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueueArray<>(5);
        queue.enqueue(10);
        queue.enqueue(100);
        queue.enqueue(66);
        queue.enqueue(99);
        queue.enqueue(1);
        queue.enqueue(-1);


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
