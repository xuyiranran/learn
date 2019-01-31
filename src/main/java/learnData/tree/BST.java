package learnData.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private Node<E> root;

    private int size;

    private class Node<E> {

        private E e;
        private Node<E> left;
        private Node<E> right;

        public Node(E e) {
            this.e = e;
        }
    }

    public BST(E e) {
        root = new Node<>(e);
        size++;
    }

    public BST() {
        //do nothing
    }

    /**
     * 增加节点
     *
     * @param e
     */
    public void add(E e) {

        if (root == null) {
            root = new Node<>(e);
            size++;
            return;
        }
        if (root.e.compareTo(e) == 0) {
            return;
        }
        if (e.compareTo(root.e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(root.e) > 0 && root.right == null) {
            root.right = new Node<>(e);
            size++;
            return;
        }
        add(root, e);

    }

    private void add(Node<E> node, E e) {
        if (node == null) {
            node = new Node<>(e);
            size++;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        }
        if (e.compareTo(node.e) > 0) {
            add(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e.toString());
        preOrder(root.left);
        preOrder(root.right);

    }

    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node<E> root) {
        if (root == null) return;
        midOrder(root.left);
        System.out.println(root.e.toString());
        midOrder(root.right);
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        bst.add(10);
        bst.add(3);
        bst.add(16);
        bst.add(1);
        bst.add(2);
        System.out.println(bst.getSize());
        System.out.println(bst.isEmpty());


        System.out.println("======");
        bst.preOrder();
        System.out.println("======");
        bst.midOrder();


    }


}
