package learn_data_structure.queue_stack;

/**
 * 基于循环数组实现队列
 */
public class ArrayQueue implements Queue {


    private int data[];
    private int capacity;
    private int start, end;
    private int size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }

    @Override
    public void enqueue(int element) {
        if ((end + 1) % capacity == start) {
            throw new IllegalStateException("队列已经满了");
        }
        data[end % capacity] = element;
        end = ((end + 1) % capacity);
        size++;
    }

    @Override
    public int dequeue() {
        checkEmpty();
        int result = data[start];
        start = (start + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public int peek() {
        checkEmpty();
        return data[start];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkEmpty() {
        if (isEmpty()) throw new IllegalStateException("空链表");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        for (int i = start; i != end; i = (i + 1) % capacity) {
//            sb.append(data[i] + "->");
//        }

        //这种循环方式相对比较简单
        for (int i = 0; i < size; i++) {
            sb.append(data[(i + start) % capacity] + "==>");
        }
        return sb.toString();
    }

    public static void main(String[] args) {


        Queue queue = new ArrayQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(5);

        System.out.println(queue.size());
        System.out.println(queue.toString());


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


    }


}
