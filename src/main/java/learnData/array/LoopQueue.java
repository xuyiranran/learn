package learnData.array;

/**
 * 基于头尾指针数组实现循环队列
 * 头尾指针数组指的是
 * 由于普通数组实现队列出队操作性能比较低需要移动较多数据,使用front和tail指针,出队操作只需要维护front指针.
 * 当front==tail时表示队列为空.
 * 当(tail+1)%capacity==front时表示队列满了.这里会多分配一个额外空间来区别空和满.
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 队列数组
     */
    private E[] data;

    /**
     * 头尾指针
     */
    private int front, tail;

    /**
     * 队列元素size和队列容量(size+1=capacity表示队列满了)
     */
    private int size, capacity;


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public LoopQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(E e) {

        if (size >= data.length - 1) {
            resize(data.length * 2 + 1);
        }
        data[tail % data.length] = e;
        tail++;
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("空数组");
        } else {
            E removeData = data[front];
            front = (front + 1) % data.length;
            size--;
            return removeData;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("空数组");
        } else {
            return data[front];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("front:[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i] + "->");
        }
        sb.append("]:tail:");
        return sb.toString();
    }


    public static void main(String[] args) {

        Queue<Integer> queue=new LoopQueue<>(10);
        for (int i = 0; i < 16; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());
        System.out.println(queue);

        int data=queue.dequeue();
        System.out.println(data);
        System.out.println(queue);

    }
}
