package learnData.linklist;

import java.util.Objects;

/**
 * 链表数据结构(单向链表,包含虚拟首节点)
 *
 * @param <E>
 */
public class LinkedList<E extends Comparable<E>> {


    /**
     * 链表头,有时候为了方便删除还有增加tail节点
     */
    private Node<E> head;
    /**
     * 链表实际包含元素size
     */
    private int size;

    /**
     * 虚拟节点(没有实际意义,仅仅只是方便操作链表)
     */
    private Node<E> dummyHead;


    private static class Node<E extends Comparable<E>> {
        private E e;
        private Node<E> next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
        }
    }

    /**
     * 链表初始化
     *
     * @param e 头节点元素
     */
    public LinkedList(E e) {
        dummyHead = new Node<>();
        if (e != null) {
            Node<E> node = new Node<>(e, null);
            head = node;
            size++;
        }
        dummyHead.next = head;
    }

    public LinkedList() {
        this(null);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of exception");
        }
        Node pre = dummyHead;
        Node<E> addNode = new Node<>(e);
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        addNode.next = pre.next;
        pre.next = addNode;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }


    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of exception");
        }
        Node<E> pre = dummyHead;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        Node<E> removeData = pre.next;
        pre.next = removeData.next;
        removeData.next = null;
        return removeData.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size);
    }

    public void remove(E data) {

        if (isEmpty()) throw new RuntimeException("空链表");
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.compareTo(data) == 0) {
                Node delNode=pre.next;
                pre.next=delNode.next;
                delNode=null;
                size--;
                return;
            }
            pre = pre.next;
        }
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of exception");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public boolean contains(E e) {
        Node<E> pre = dummyHead;
        while (pre.next != null) {
            if (e.compareTo(pre.next.e) == 0) {
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cur = dummyHead;
        while (cur.next != null) {
            sb.append(cur.next.e + "->");
            cur = cur.next;
        }
        sb.append("linklist:" + size);
        return sb.toString();

    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.size);
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList.size);
        linkedList.add(3, 999);
        linkedList.remove(9);
        linkedList.add(5, 999);
        linkedList.add(5, 999);
        linkedList.add(5, 999);
        linkedList.remove(999);
        System.out.println(linkedList);

        Node<Integer> pre = linkedList.dummyHead;
        while (pre.next != null) {
            Node<Integer> delNode = pre.next;
            if (delNode.e == 999) {
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }

        System.out.println(linkedList);

    }
}
