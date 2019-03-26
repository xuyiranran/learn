package chengxuyuanmianshizhinan.stack.second_linkedlist;

public class LinkedList {

    private Node head;
    private int size;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList() {
    }

    public void addFirst(int data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        } else {
            head = new Node(data, head);
            size++;
        }
    }

    public void addKth(int index, int data) {
        if (index > getSize()) throw new IndexOutOfBoundsException("");
        size++;
        if (index == 0) head = new Node(data, head);
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        Node node = new Node(data, pre.next);
        pre.next = node;
    }

    public int removeFirst() {
        if (isEmpty()) throw new IllegalArgumentException("空链表");
        int result = head.data;
        head = head.next;
        size--;
        return result;
    }

    public int removeKth(int index) {
        if (isEmpty()) throw new IllegalArgumentException("空链表");
        if (index >= getSize()) throw new IndexOutOfBoundsException("");
        if (index == 0) {
            size--;
            int result = head.data;
            head = head.next;
            return result;
        }
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        int result = pre.next.data;
        pre.next = pre.next.next;
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data + "->");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList.toString());

        linkedList.removeKth(2);
        linkedList.removeKth(4);
        linkedList.addKth(4, 100);
        System.out.println(linkedList.toString());

    }
}
