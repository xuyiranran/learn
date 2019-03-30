package learnData.code_training;

/**
 * 双向链表实现
 */
public class MyLinkedList {


    private static class Node {
        int data;
        Node pre, next;

        public Node(int data) {
            this(data, null, null);
        }

        public Node(int data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    private Node head, tail;
    private int size;


    public MyLinkedList() {
        head = new Node(-1, null, null);
        tail = new Node(1, head, null);
        head.next = tail;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int data) {

        Node insert = new Node(data, head, null);
        insert.next = head.next;
        head.next = insert;
        size++;
    }

    public boolean contains(int data) {
        Node cur = head;
        while (cur != tail) {
            if (cur.data == data) return true;
            cur = cur.next;
        }
        return false;
    }

    public int removeKth(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("");
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node removeNode=cur.next;
        cur.next = removeNode.next;
        cur.next.pre = cur.next;
        return removeNode.data;
    }

    public void remove(int data) {
        Node cur = head;
        while (cur != tail) {
            if (cur.data == data) {
                Node pre = cur.pre;
                Node next = cur.next;
                cur.pre.next = pre.next.next;
                next.pre = next.pre.pre;
                cur = null;
                return;
            }else {
                cur = cur.next;
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node cur = head.next;
        while (cur != tail) {
            sb.append(cur.data + "->");
            cur = cur.next;
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        System.out.println(linkedList.toString());

        linkedList.remove(11);
        System.out.println(linkedList);

        linkedList.removeKth(0);
        System.out.println(linkedList);


    }

}
