package learnData.linklist;

import learnData.array.Queue;

public class LinkedListQueue<E> implements Queue<E> {


    private int size;

    private Node head, tail;

    private class Node {

        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

    }

    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        Node removeData = head;
        head = head.next;

        if (head==null){
            tail=null;
        }
        size--;
//        removeData.next=null;
        return removeData.e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return head.e;
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
        StringBuilder sb=new StringBuilder();
        Node cur=head;
        while (cur!=null){
            sb.append(cur.e.toString()+"<-");
            cur=cur.next;
        }
        sb.append("null"+"queue size:"+size);
        return sb.toString();
    }


    public static void main(String[] args) {

        LinkedListQueue<Integer> queue=new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());

    }
}
