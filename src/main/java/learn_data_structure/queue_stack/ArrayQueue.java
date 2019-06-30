package learn_data_structure.queue_stack;

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
        while ((end + 1) % size != start) {
            sb.append(data[start] + "->");
            start++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {


        Queue queue = new ArrayQueue(3);

        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);

        System.out.println(queue.dequeue());

        System.out.println(queue.dequeue());


    }


}
