package chengxuyuanmianshizhinan.stack;

public class Stack {

    private int[] array;
    private int size;
    private boolean empty;

    public Stack(int capacity) {
        array = new int[capacity];
    }

    public void push(int data) {
        array[size] = data;
        size++;
    }

    public int pop() {
        if (size == 0) throw new IndexOutOfBoundsException("空栈");
        int result = array[size - 1];
        size--;
        return result;
    }

    public int peek() {
        if (size == 0) throw new IndexOutOfBoundsException("空栈");
        int result = array[size - 1];
        return result;
    }

    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
