package learn_data_structure.linkedlist;

/**
 * 双向循环链表,其实和单向没什么太大区别
 */
public class CycleDoubleLinkedList {


    //头尾节点
    private Node head, tail;
    //链表长度大小
    private int size;

    private static class Node {

        private Node pre;
        private Node next;
        private int value;

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
            head.next = tail;
            head.pre = tail;
            tail.next = head;
            tail.pre = head;
        } else {
            head = new Node(tail, head, value);
            tail.next = head;
        }
        size++;
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("空链表");
        int ret = head.value;
        if (size == 1) {
            head = tail = null;
        } else {
            tail.next = head.next;
            head = head.next;
            head.pre = tail;
        }
        size--;
        return ret;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        //第一种循环方式
//        while (cur.next != head) {
//            sb.append(cur.value + "->");
//            cur = cur.next;
//        }
//        sb.append(cur.value);

        //第二种循环方式
        for (int i = 0; i < size; i++) {
            sb.append(cur.value + "->");
            cur = cur.next;
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        CycleDoubleLinkedList list = new CycleDoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.toString());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.toString());
    }


}
