package learn_leetcode.linkedlist;

public class MyCircularQueue {


    //头尾节点
    private Node head, tail;
    //链表长度大小
    private int size;
    //链表容量大小
    private int capacity;


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

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())return false;
        if (isEmpty()){
            head=tail=new Node(value);
        }else {
            Node addNode=new Node(value);
            tail.next=addNode;
            tail=addNode;
        }
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())return false;
        head=head.next;
        if (head==null){
            tail=null;
        }
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())return -1;
        return head.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())return -1;
        return tail.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==capacity;
    }

    public static void main(String[] args) {

    }

}
