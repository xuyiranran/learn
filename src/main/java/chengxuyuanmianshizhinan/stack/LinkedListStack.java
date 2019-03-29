package chengxuyuanmianshizhinan.stack;

/**
 * 链表实现栈数据结构
 *
 * @param <E>
 */
public class LinkedListStack<E extends Comparable> {

    private Node<E> head;
    private int size;

    private static class Node<E> {

        private Node next;
        private E data;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }
    }

    //入栈操作(添加节点到链表头节点)
    public void push(E data) {
        head = new Node<>(data, head);
        size++;
    }

    //出栈操作(删除链表头节点)
    public E pop() {
        if (size == 0) throw new IllegalArgumentException("空栈");
        Node<E> removeNode = head;
        head = head.next;
        size--;
        return removeNode.data;
    }

    //获取栈顶元素
    public E peek() {
        if (size == 0) throw new IllegalArgumentException("空栈");
        return head.data;
    }

    //返回栈大小
    public int getSize() {
        return size;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
