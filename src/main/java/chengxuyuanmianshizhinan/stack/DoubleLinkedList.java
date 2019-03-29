package chengxuyuanmianshizhinan.stack;

/**
 * 双链表
 *
 * @param <E>
 */
public class DoubleLinkedList<E extends Comparable> {


    private Node<E> head, tail;//头尾节点
    private int size;//链表size

    private static class Node<E> {
        private E data;//节点元素
        private Node next;//下一个节点引用
        private Node pre;//前一个节点引用

        public Node(E data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node(E data) {
            this(data, null, null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加头节点
    public void addFirst(E data) {
        //如果是空链表,头节点也就是尾节点
        if (isEmpty()) {
            head = new Node(data, null, null);
            tail = head;
            size++;
            return;
        }
        //新的头节点next指向原先的头节点
        Node addNode = new Node(data, null, head);
        head.pre = addNode;
        head = addNode;
        size++;
    }

    //添加尾节点
    public void addLast(E data) {
        //如果是空链表,头节点也就是尾节点
        if (isEmpty()) {
            addFirst(data);
            return;
        }
        //新的尾节点pre指向原先的尾节点
        Node addNode = new Node(data, tail, null);
        tail.next = addNode;
        tail = addNode;
        size++;
    }

    //添加元素到指定下标
    public void addKth(int index, E data) {
        if (index < 0 || index > getSize()) throw new IllegalArgumentException("不合法下标");
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == getSize()) {
            addLast(data);
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node addNode = new Node(data, cur, cur.next);
        cur.next.pre = addNode;
        cur.next = addNode;
        size++;
    }

    public void add(Node node, E data) {
        if (node == null) throw new IllegalArgumentException();
        Node addNode = new Node(data, node, node.next);
        node.next = addNode;
        if (node.next != null) {
            node.next.pre = addNode;
        }
    }

    public void remove(Node node) {

        if (node == null) throw new IllegalArgumentException();
        if (node.pre != null && node.next != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        //node为尾及诶单
        if (node.pre != null && node.next == null) {
            node.pre.next = null;
        } else if (node.next != null && node.pre == null) {
            node.next.pre = null;
        } else if (node.next == null && node.pre == null) {
            node = null;
        }

    }


    //删除头节点
    public E removeFirst() {
        if (isEmpty()) throw new IllegalArgumentException("空链表");
        Node<E> removeNode = head;
        head = head.next;
        head.pre = null;
        size--;
        return removeNode.data;
    }

    //删除尾节点
    public E removeLast() {
        if (isEmpty()) throw new IllegalArgumentException("空链表");
        Node<E> removeNode = tail;
        tail = tail.pre;
        tail.next = null;
        size--;
        return removeNode.data;
    }

    //删除指定下标元素
    public E removeKth(int index) {
        if (isEmpty()) throw new IllegalArgumentException("空链表");
        if (index == 0) return removeFirst();
        if (index == getSize() - 1) return removeLast();
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node<E> removeNode = cur.next;
        cur.next = removeNode.next;
        removeNode.next.pre = cur;
        return removeNode.data;
    }

    //判断链表是否包含指定元素
    public boolean contains(E data) {
        if (isEmpty() || data == null) return false;
        Node<E> cur = head;
        while (cur != null) {
            if (cur.equals(data)) return true;
            cur = cur.next;
        }
        return false;
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

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addFirst("head1");
        linkedList.addFirst("head2");

        linkedList.addLast("last1");
        linkedList.addLast("last2");
        System.out.println(linkedList.toString());
        linkedList.add(linkedList.head, "first");
        linkedList.add(linkedList.tail, "end");
        System.out.println(linkedList.toString());
        linkedList.remove(linkedList.head.next);
        System.out.println(linkedList.toString());
        linkedList.addKth(1, "1head");
        linkedList.addKth(3, "3th");
        System.out.println(linkedList.toString());
        linkedList.removeKth(1);
        linkedList.removeKth(2);
        System.out.println(linkedList.toString());
        linkedList.removeFirst();
        System.out.println(linkedList.toString());
        linkedList.removeLast();
        System.out.println(linkedList.toString());

    }

}
