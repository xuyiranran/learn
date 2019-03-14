package learnData.code_training;

import learnData.array.Queue;

public class ArrayQueue implements Queue<Integer> {


    private int[] data;
    private int front, end;
    private int size = 0;


    public ArrayQueue() {
        data = new int[DEFAULT_CAPACITY];
        front = end = 0;
    }

    public ArrayQueue(int capacity) {
        data = new int[capacity];
        front = end = 0;
    }

    @Override
    public void enqueue(Integer element) {
        if (isFull()) {
            resize(data.length * 2);
        }
        data[end] = element;
        end = (end + 1) % data.length;
        size++;
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) throw new RuntimeException("空队列");
        int removeData = data[front];
        front = (front + 1) % data.length;
        size--;
        return removeData;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) throw new RuntimeException("空队列");
        return data[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private boolean isFull() {
        if ((end + 1) % data.length == front) return true;
        return false;
    }


    private void resize(int newSize) {
        int[] newData = new int[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        end = size - 1;
    }


    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
