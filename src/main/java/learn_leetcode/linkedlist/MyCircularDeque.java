package learn_leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class MyCircularDeque {


    //头尾节点
    private Node head, tail;
    //链表长度大小
    private int size;
    //链表容量大小
    private int capacity;


    private static class Node {

        private Node pre;
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            head = tail = new Node(head, value, tail);
            head.next = tail;
            head.pre = tail;
            tail.pre = head;
            tail.next = head;
        } else {
            head = new Node(tail, value, head);
            //TODO 这部分实现还有点问题
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            head = tail = new Node(value);
            head.next = tail;
            head.pre = tail;
            tail.pre = head;
            tail.next = head;
        } else {
            Node addNode = new Node(tail, value, head);
            tail.next = addNode;
            tail = addNode;
            head.pre = tail;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = tail = null;
        } else {
            Node newTail = tail.pre;
            newTail.next = head;
            tail = newTail;
            head.pre = newTail;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return head.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return tail.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void print(MyCircularDeque list) {

        Node cur = list.head;
        for (int i = 0; i < list.size; i++) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println();

        Node cur1 = list.tail;
        for (int i = 0; i < list.size; i++) {
            System.out.print(cur1.value + "->");
            cur1 = cur1.pre;
        }
        System.out.println();


    }


    public static void main(String[] args) {

        MyCircularDeque list = new MyCircularDeque(10);
        list.insertFront(1);
        list.insertFront(27);
        list.insertFront(100);
        print(list);
        list.deleteLast();
        list.insertFront(60);
        list.insertFront(81);

        print(list);//
        System.out.println(list.getRear());

    }


}
