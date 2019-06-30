package learn_data_structure.linkedlist;

public class LinkedList {


    //链表头结点
    private Node root;

    //链表大小
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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int value) {
        if (isEmpty()) {
            root = new Node(value);
        } else {
            root = new Node(root, value);
        }
        size++;
    }

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

    public void addKth(int index, int value) {



    }

    public int removeFirst() {
        return 0;
    }

    public int removeKth(int index) {
        return 0;
    }

    public int getKth(int index) {
        checkIndex(index);
        Node cur = root;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    private void checkIndex(int index) {
        if (index >= size) throw new IllegalArgumentException("超出链表范围");
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

        System.out.println(linkedList.toString());

        System.out.println(linkedList.contains(3));

    }

}
