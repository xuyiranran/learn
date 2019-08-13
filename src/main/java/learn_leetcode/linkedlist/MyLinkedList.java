package learn_leetcode.linkedlist;

/**
 *
 * 707. 设计链表
 *
 * 该题目前提交还是有点问题,需排查
 *
 */
public class MyLinkedList {


    private Node head, tail;
    private int size = 0;

    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this(value, null);
        }

        public Node() {
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {

        if (index >= size || head == null) return -1;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {

        if (size == 0) {
            head = tail = new Node();
            size++;
        } else {
            head = new Node(val, head);
            size++;
        }

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {

        if (size == 0) {
            head = tail = new Node();
            size++;
        } else {
            Node addNode = new Node(val, null);
            tail.next = addNode;
            tail = addNode;
            size++;
        }

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index > size) return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node addNode = new Node(val, cur.next);
            cur.next = addNode;
            size++;
        }


    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size || head == null) return;
        if (index == 0) {
            head = head.next;
            if (head == null) {
                head = tail = null;
            }
            size--;
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }

    }

    public static void main(String[] args) {


    }
}
