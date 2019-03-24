package chengxuyuanmianshizhinan.stack;

public class Stack {

    private int[] array;
    private int size;
    private int capacity;
    private boolean empty;

    public Stack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void push(int data) {
        if (size + 1 >= capacity) {
            resize(capacity * 2);
        }
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

    //扩容和缩容
    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
