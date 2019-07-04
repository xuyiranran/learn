package learn_data_structure.linkedlist;

/**
 * 循环链表
 */
public class CycleLinkedList {


    //头尾节点
    private Node head, tail;
    //链表长度大小
    private int size;

    private static class Node {

        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, int value) {
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
            tail.next = head;
        } else {
            head = new Node(head, value);
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
        }
        size--;
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        //第一种循环方式
        while (cur.next != head) {
            sb.append(cur.value + "->");
            cur = cur.next;
        }
        sb.append(cur.value);

        //第二种循环方式
//        for (int i = 0; i < size; i++) {
//            sb.append(cur.value + "->");
//            cur = cur.next;
//        }

        return sb.toString();
    }

    public static void main(String[] args) {

        CycleLinkedList list = new CycleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.toString());


        System.out.println(list.remove());
        System.out.println(list.remove());

        System.out.println(list.toString());

        System.out.println(System.currentTimeMillis());


    }

}
