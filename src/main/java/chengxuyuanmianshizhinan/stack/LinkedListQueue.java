package chengxuyuanmianshizhinan.stack;

/**
 * 链表实现队列数据结构(维护头尾节点,从链表尾添加节点,从链表头删除节点)
 * <p>
 * 由于链表的添加操作是O(1)复杂度,链表的删除操作是O(n)复杂度.因此维护头尾节点来实现.
 *
 * @param <E>
 */
public class LinkedListQueue<E extends Comparable> {

    //维护头尾节点实现队列数据结构
    private Node<E> head, tail;
    //队列大小
    private int size;

    private static class Node<E extends Comparable> {
        private E data;
        private Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    //入队操作(添加链表尾节点)
    public void enqueue(E data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
            size++;
            return;
        }
        Node addNode = new Node(data, null);
        tail.next = addNode;
        tail = addNode;
        size++;
        return;
    }

    //出队操作(删除链表头节点)
    public E dequeue() {
        if (size == 0) throw new IllegalArgumentException("空队列");
        Node<E> removeNode = head;
        head = head.next;
        size--;
        return removeNode.data;
    }

    //弹出队列元素(获取链表头节点)
    public E pop() {
        if (size == 0) throw new IllegalArgumentException("空队列");
        return head.data;
    }

    //返回队列size大小
    public int getSize() {
        return size;
    }

    //判断对哦是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
