package learn_data_structure.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedList {

    private Node head, tail;
    private int size;

    private static class Node {

        public Node pre;
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node pre, Node next, int value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int value) {
        if (isEmpty()) {
            head = tail = new Node(value);
        } else {
            head = new Node(null, head, value);
        }
        size++;

    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("空链表");
        int remove = head.value;
        if (getSize() == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }
        size--;
        return remove;
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

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.toString());


        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());

        System.out.println(list.toString());

    }

}
