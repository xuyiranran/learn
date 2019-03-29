package chengxuyuanmianshizhinan.stack;

import com.sun.istack.internal.NotNull;

/**
 * @param <K>
 */
public class LinkedList<K extends Comparable, V> {

    private Node<K, V> head;//头节点
    private Node<K, V> dummyHead;//虚拟头节点(辅助节点)
    private int size;//链表大小

    private static class Node<K extends Comparable, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }
    }

    public LinkedList() {
        dummyHead = new Node("dummy", -1);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //新增头节点
    public void addFirst(K key, @NotNull V value) {
        //如果头节点为空
        head = new Node(key, value, head);
        dummyHead.next = head;
        size++;
    }

    //新增尾节点
    public void addLast(K key, V value) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(key, value);
        head = dummyHead.next;
        size++;
    }

    //添加元素到指定下标
    public void addKth(int index, K key, V value) {
        if (index > getSize()) throw new IllegalArgumentException("不合法下标");
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new Node(key, value, cur.next);
        head = dummyHead.next;
        size++;
    }

    //删除头节点
    public V removeFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException("空链表");
        Node<K, V> node = head;
        head = dummyHead.next.next;
        dummyHead.next = head;
        size--;
        return node.value;
    }

    //删除最后一个节点
    public V removeLast() {
        if (isEmpty()) throw new IndexOutOfBoundsException("空链表");
        Node<K, V> cur = dummyHead;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        head = dummyHead.next;
        size--;
        return cur.value;
    }

    //删除指定下标元素
    public V removeKth(int index) {
        if (isEmpty()) throw new IndexOutOfBoundsException("空链表");
        if (index < 0 || index >= getSize()) throw new IllegalArgumentException("不合法下标" + index);

        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node<K, V> delNode = cur.next;
        cur.next = cur.next.next;
        head = dummyHead.next;
        size--;
        return delNode.value;

    }

    //获取头节点元素
    public V getFirst() {
        return getKth(0);
    }

    //获取尾节点元素
    public V getLast() {
        return getKth(getSize() - 1);
    }

    //获取指定下标元素
    public V getKth(int index) {
        if (isEmpty()) throw new IndexOutOfBoundsException("空链表");
        if (index < 0 || index >= getSize()) throw new IllegalArgumentException("不合法下标" + index);
        Node<K, V> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }


    //查询链表是否包含指定元素
    public boolean contains(K key) {
        Node<K, V> cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) return true;
            cur = cur.next;
        }
        return false;
    }

    //更新链表指定元素
    public boolean set(K key, V value) {
        Node<K, V> cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        if (isEmpty()) return null;
        Node<K, V> cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead;
        while (cur.next != null) {
            sb.append(cur.next.value + "->");
            cur = cur.next;
        }
        return sb.toString();
    }

    public String print(Node node) {
        if (node == null) return "";
        System.out.print(node.key + "->");
        return print(node.next);
    }

    public static void main(String[] args) {

        LinkedList<String, String> linkedList = new LinkedList<>();
        linkedList.addFirst("hello", "hello");
        linkedList.addLast("world", "world");
        linkedList.addKth(2, "java", "java");
        System.out.println(linkedList.toString());
        linkedList.print(linkedList.head);
        System.out.println("----");

        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        linkedList.addKth(0, "1", "1");
        linkedList.addKth(0, "101", "101");
        linkedList.addFirst("first", "first");
        linkedList.addKth(2, "100", "100");
        System.out.println(linkedList.toString());

        linkedList.removeLast();
        linkedList.removeKth(1);
        System.out.println("---");
        System.out.println(linkedList.toString());
        System.out.println("---");

        linkedList.print(linkedList.head);

        System.out.println("----");
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getSize());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.contains("world"));

    }

}
