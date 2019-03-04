package learnData.code_training;

/**
 * 链表实现(单链表)
 */
public class LinkedList {


    //头节点
    private Node root;
    //链表元素个数
    private int size;
    //虚拟头节点
    private Node preHead;


    public LinkedList() {
        preHead = new Node(-1);
    }

    public LinkedList(int rootData) {
        root = new Node(rootData);
        preHead = new Node(-1);
        preHead.next = root;
    }


    /**
     * 添加元素到链表头
     *
     * @param data
     */
    public void addFirst(int data) {
        if (root == null) {
            root = new Node(data);
            preHead.next = root;
            size++;
            return;
        }
        Node node = new Node(data);
        node.next = root;
        root = node;
        preHead.next = node;
        size++;
    }


    /**
     * 添加元素到指定链表的index的元素(实际应用是没什么意义,因为链表的index通常都是没用的,无法随机访问)
     *
     * @param index
     * @param element
     */
    public void addIndex(int index, int element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node cur = preHead;
        int count = 0;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node node = new Node(element);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public int removeFirst() {
        if (root == null) {
            throw new IllegalArgumentException("空链表");
        }
        int removeData = root.data;
        preHead.next = preHead.next.next;
        root = preHead.next;
        //以下这种方式也可以,但是既然使用了虚拟头节点那么久主推义虚拟头结点来操作.
//        root = root.next;
//        preHead.next = root;
        size--;
        return removeData;
    }


    /**
     * 删除链表指定index的节点(实际应用是没什么意义,因为链表的index通常都是没用的,无法随机访问)
     *
     * @param index
     * @return
     */
    public int removeIndex(int index) {

        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node cur = preHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        int removeData = cur.next.data;
        cur.next = cur.next.next;
        size--;
        return removeData;

    }


    public boolean contains(int data) {
        Node cur = preHead;
        while (cur.next != null) {
            if (cur.next.data == data) return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node pre = preHead;
        while (pre.next != null) {
            sb.append(pre.next.data + "->");
            pre = pre.next;
        }
        return sb.toString();
    }

    private static class Node {

        //节点数据
        private int data;
        //下一个节点引用
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addIndex(0, 99);
        linkedList.addIndex(2, 100);

        System.out.println(linkedList.toString());


        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        System.out.println(linkedList.removeIndex(0));
        System.out.println(linkedList.removeIndex(1));

        System.out.println(linkedList.toString());

    }


}
