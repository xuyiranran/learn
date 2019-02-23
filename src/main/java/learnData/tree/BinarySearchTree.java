package learnData.tree;

public class BinarySearchTree<E extends Comparable> {

    private Node<E> root;
    private int size;

    private static class Node<E extends Comparable> {

        public E data;
        public Node<E> left;
        public Node<E> right;

        public Node(E e) {
            this.data = e;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree(E data) {
        size++;
        this.root = new Node<>(data);
    }

    public BinarySearchTree() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E data) {
        root = addNode(root, data);
    }

    private Node<E> addNode(Node<E> node, E data) {
        if (node == null) {
            size++;
            return new Node<>(data);
        }
        int compare = data.compareTo(node.data);
        if (compare < 0) {
            node.left = addNode(node.left, data);
        } else if (compare > 0) {
            node.right = addNode(node.right, data);
        } else {
            //重复元素不处理
        }
        return node;
    }

    public E min() {
        return min(root).data;
    }

    private Node<E> min(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return min(node.left);
    }

    public E max() {
        return max(root).data;
    }

    private Node<E> max(Node node) {
        if (node == null) return null;
        if (node.right == null) return node;
        return max(node.right);
    }

    public E removeMin() {
        E result=min();
        root = removeMin(root);
        return result;
    }

    private Node<E> removeMin(Node node) {
        if (node == null) return null;
        if (node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E result=max();
        root = removeMax(root);
        return result;
    }

    private Node<E> removeMax(Node node) {
        if (node == null) return null;
        if (node.right==null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E data) {
        root = remove(root, data);
    }

    private Node<E> remove(Node node, E data) {
        if (node == null) return null;
        int compare = data.compareTo(node.data);
        if (compare < 0) {
            node.left = remove(node.left, data);
        } else if (compare > 0) {
            node.right = remove(node.right, data);
        } else {
            //data==node.data
            //待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树都不为空
            //1、寻找出待删除节点右子树中最小节点(后继节点)/寻找出待删除节点左子树中最大节点(前驱节点)
            //2、删除右子树的最小节点/删除左子树最大节点
            //3、将后继节点或前驱节点替代待删除节点位置
            Node<E> successor = min(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            //回收node节点
            node.left = node.right = null;
            return successor;
        }
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + "-->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void middleOrder() {
        middleOrder(root);
    }

    private void middleOrder(Node node) {
        if (node == null) return;
        middleOrder(node.left);
        System.out.print(node.data + "-->");
        middleOrder(node.right);
    }

    public void afterOrder() {
        afterOrder(root);
    }

    private void afterOrder(Node node) {
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.print(node.data + "-->");
    }


    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(8);
        bst.add(4);
        bst.add(13);
        bst.add(18);
        bst.add(4);
        bst.add(17);

        bst.preOrder();
        System.out.println();
        System.out.println(bst.max().toString());
        System.out.println(bst.min().toString());

        bst.remove(3);
        bst.middleOrder();
        System.out.println();
        bst.remove(15);
        bst.middleOrder();
        System.out.println();
        System.out.println(bst.size);


    }
}
