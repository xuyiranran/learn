package chengxuyuanmianshizhinan.stack;

/**
 * @param <T>
 */
public class LinkedList<T extends Comparable> {

    private Node<T> head;//头节点
    private Node<T> dummyHead;//虚拟头节点(辅助节点)
    private int size;//链表大小

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }
    }

    public LinkedList() {
        dummyHead = new Node(-1);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //新增头节点
    public void addFirst(T data) {
        //如果头节点为空
        head = new Node(data, head);
        dummyHead.next = head;
        size++;
    }

    //新增尾节点
    public void addLast(T data) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(data);
        head = dummyHead.next;
        size++;
    }

    //添加元素到指定下标
    public void addKth(int index, T data) {
        if (index > getSize()) throw new IllegalArgumentException("不合法下标");
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new Node(data, cur.next);
        head = dummyHead.next;
        size++;
    }

    //删除头节点
    public T removeFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException("空链表");
        Node<T> node = head;
        head = dummyHead.next.next;
        dummyHead.next = head;
        return node.data;
    }

    //删除最后一个节点
    public T removeLast() {
        if (isEmpty()) throw new IndexOutOfBoundsException("空链表");
        Node<T> cur = dummyHead;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        head = dummyHead.next;
        return cur.data;
    }

    //删除指定下标元素
    public T removeKth(int index) {
        if (isEmpty()) throw new IndexOutOfBoundsException("空链表");
        if (index < 0 || index >= getSize()) throw new IllegalArgumentException("不合法下标" + index);

        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node<T> delNode = cur.next;
        cur.next = cur.next.next;
        head = dummyHead.next;
        return delNode.data;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node cur = dummyHead;
        while (cur.next != null) {
            sb.append(cur.next.data + "->");
            cur = cur.next;
        }
        return sb.toString();
    }

    public String print(Node node) {
        if (node == null) return "";
        System.out.print(node.data + "->");
        return print(node.next);
    }

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("hello");
        linkedList.addLast("world");
        linkedList.addKth(2, "java");
        System.out.println(linkedList.toString());
        linkedList.print(linkedList.head);
        System.out.println("----");

        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        linkedList.addKth(0, "1");
        linkedList.addKth(0, "101");
        linkedList.addFirst("first");
        linkedList.addKth(2, "100");
        System.out.println(linkedList.toString());

        linkedList.removeLast();
        linkedList.removeKth(1);
        System.out.println("---");
        System.out.println(linkedList.toString());
        System.out.println("---");

        linkedList.print(linkedList.head);

    }

}
