package learn_data_structure.queue_stack;

/**
 * 数组实现栈
 */
public class ArrayStack implements Stack {

    //存储元素数组
    private int[] data;

    //栈元素个数
    private int size;

    public ArrayStack(int capacity) {
        data = new int[capacity];
    }

    @Override
    public void push(int element) {
        data[size] = element;
        size++;
    }

    @Override
    public int pop() {
        checkEmpty();
        int ret = data[size - 1];
        size--;
        return ret;
    }

    @Override
    public int peek() {
        checkEmpty();
        return data[size - 1];
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

        for (int i = 0; i < size; i++) {
            sb.append(data[size - 1 - i] + "->");
        }
        return sb.toString();

    }

    public static void main(String[] args) {


        Stack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toString());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
