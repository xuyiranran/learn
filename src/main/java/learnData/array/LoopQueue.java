package learnData.array;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front;

    private int tail;

    private int size;

    //构造方法
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public LoopQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(E e) {

        if (isEmpty()) {
            data[front] = e;
            tail = tail + 1;
        } else {
            if (size > data.length - 1) {
                resize(data.length * 2 + 1);
            }
            data[tail] = e;
            tail = (tail + 1) % data.length;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("空数组");
        } else {
            if (size < data.length / 2) {
                resize(data.length / 2);
            }
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
        sb.append("front:"+front);
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i] + "->");
        }
        sb.append("tail:"+tail);
        return sb.toString();
    }
}
