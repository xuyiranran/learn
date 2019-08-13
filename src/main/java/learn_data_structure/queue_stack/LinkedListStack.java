package learn_data_structure.queue_stack;

/**
 * 基于链表实现的栈
 */
public class LinkedListStack implements Stack {


    //链表根节点
    private Node root;

    //指向头节点的一个虚拟节点
    private Node dumyhead = new Node(root, -1);

    //链表元素个数
    private int size;


    static class Node {

        public Node next;
        public int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public Node(int value) {
            this.next = null;
            this.value = value;
        }

    }

    public LinkedListStack(){

    }

    @Override
    public void push(int element) {
        root = new Node(root, element);
        dumyhead.next = root;
        size++;
    }

    @Override
    public int pop() {
        checkEmpty();
        int ret = root.value;
        if (size == 1) {
            root = null;
        } else {
            dumyhead.next = root.next;
            root=new Node(root.next.next,root.next.value);
        }
        size--;
        return ret;
    }

    @Override
    public int peek() {
        checkEmpty();
        return root.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkEmpty() {
        if (isEmpty()) throw new IllegalStateException("空链表");
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder=new StringBuilder();
        Node cur=root;
        while (cur!=null){
            stringBuilder.append(cur.value+"->");
            cur=cur.next;
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {

        Stack stack=new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toString());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        StringBuilder stringBuilder=new StringBuilder("hello");
        System.out.println(stringBuilder.reverse().toString());

    }

}
