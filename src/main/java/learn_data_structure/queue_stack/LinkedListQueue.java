package learn_data_structure.queue_stack;

/**
 * 基于头尾指针链表实现队列
 */
public class LinkedListQueue implements Queue {

    //头尾指针(尾插入、头删除)
    private Node head, tail;

    //链表元素个数
    private int size;

    static class Node {

        public Node next;
        public int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public Node(int value) {
            this.next = null;
            this.value = value;
        }

    }

    //将元素添加到链表尾部
    @Override
    public void enqueue(int element) {
        if (isEmpty()) {
            head = tail = new Node(element);
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    //删除链表头元素
    @Override
    public int dequeue() {
        checkEmpty();
        int result = head.value;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return result;
    }

    @Override
    public int peek() {
        checkEmpty();
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value + "->");
            cur = cur.next;
        }
        return sb.toString();
    }

    private void checkEmpty() {
        if (isEmpty()) throw new IllegalStateException("空链表");
    }

    public static void main(String[] args) {

        Queue queue = new LinkedListQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.toString());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
