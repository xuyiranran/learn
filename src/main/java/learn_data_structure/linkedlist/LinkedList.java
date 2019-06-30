package learn_data_structure.linkedlist;

/**
 * 单链表
 */
public class LinkedList {


    //链表头结点
    private Node root;

    //链表大小
    private int size;

    //链表结点定义
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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加节点
    public void addFirst(int value) {
        if (isEmpty()) {
            root = new Node(value);
        } else {
            root = new Node(root, value);
        }
        size++;
    }

    //在链表尾添加节点
    public void addLast(int value) {
        if (isEmpty()) {
            root = new Node(value);
        } else {
            Node cur = root;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value);
        }
        size++;
    }

    //在指定位置添加节点
    public void addKth(int index, int value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("");
        if (isEmpty()) {
            root = new Node(value);
            size++;
            return;
        }
        if (index == 0) {
            root = new Node(root, value);
            size++;
            return;
        }
        Node cur = root;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node addNode = new Node(cur.next, value);
        cur.next = addNode;
        size++;
    }

    //删除头节点
    public int removeFirst() {

        checkEmpty();
        int remove = root.value;
        if (root.next == null) {
            root = null;
        } else {
            root.next = root.next.next;
        }
        size--;
        return remove;
    }

    public int removeLast() {

        checkEmpty();
        if (size == 1) {
            int remove = root.value;
            root = null;
            size--;
            return remove;
        }
        if (size == 2) {
            int remove = root.next.value;
            root.next = null;
            size--;
            return remove;
        }
        Node cur = root;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        int remove = cur.next.value;
        cur.next = null;
        size--;
        return remove;
    }

    public int removeKth(int index) {

        checkEmpty();
        if (index == 0) return removeFirst();
        Node pre = root;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        int remove = pre.next.value;
        pre.next = pre.next.next;


        return 0;
    }

    public int getKth(int index) {
        checkIndex(index);
        checkEmpty();
        Node cur = root;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("超出链表范围");
    }

    private void checkEmpty() {
        if (isEmpty()) throw new IllegalStateException("空链表");
    }

    public boolean contains(int value) {
        if (isEmpty()) return false;
        Node cur = root;
        while (cur != null) {
            if (cur.value == value) return true;
            cur = cur.next;
        }
        return false;
    }

    public void updateKth(int index, int value) {

        checkEmpty();
        Node cur = root;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.value = value;

    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Node cur = root;
        while (cur != null) {
            stringBuilder.append(cur.value + "->");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        linkedList.addLast(100);
        linkedList.addLast(1000);
        linkedList.addLast(100000);

        linkedList.addKth(0, -1);
        linkedList.addKth(1, 1);
        linkedList.addKth(2, 2);

        System.out.println(linkedList.toString());

        System.out.println(linkedList.contains(3));

    }

}
