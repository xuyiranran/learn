package learn_data_structure.tree;

/**
 * 二分搜索树
 */
public class BST {


    //根节点
    private Node root;
    //二分搜索树大小
    private int size;

    private static class Node {

        public Node left;
        public Node right;
        public int value;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this(value, null, null);
        }
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node node, int value) {
        if (node == null) {
            size++;
            return new Node(value);
        }
        int cmp = value - node.value;
        if (cmp <= 0) {
            node.left = addNode(node.left, value);
        } else {
            node.right = addNode(node.right, value);
        }
        return node;
    }

    public void remove(int value) {


    }

    private Node removeNode(Node node, int value) {

        int cmp = value - node.value;
        if (cmp < 0) {
            node.left = removeNode(node.left, value);
        } else if (cmp > 0) {
            node.right = removeNode(node.right, value);
        } else {
            Node removeNode = node;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {

            }
        }
        return null;
    }


    @Override
    public String toString() {
        return middleNode(root);
    }

    private String preNode(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) return sb.toString();
        sb.append(node.value + "->");
        sb.append(preNode(node.left));
        sb.append(preNode(node.right));
        return sb.toString();
    }

    private String middleNode(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) return sb.toString();
        sb.append(middleNode(node.left));
        sb.append(node.value + "->");
        sb.append(middleNode(node.right));
        return sb.toString();
    }

    private String afterNode(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) return sb.toString();
        sb.append(afterNode(node.left));
        sb.append(afterNode(node.right));
        sb.append(node.value + "->");
        return sb.toString();
    }


    public static void main(String[] args) {

        BST bst = new BST();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(20);
        bst.add(3);

        System.out.println(bst.toString());
        System.out.println(bst.size);
        System.out.println(bst.root.left.value);

    }


}