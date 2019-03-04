package learnData.code_training;

/**
 * 平衡二叉树的avl实现
 * <p>
 * 平衡二叉树定义:任意节点的左右子树高度差不高于1
 */
public class AVL {


    private Node root;
    private int size;


    private static class Node {

        private int data;
        private Node left, right;
        private int height = 1;


        public Node(int data) {
            this.data = data;
        }

    }

    public void add(int data) {

        if (root == null) {
            root = new Node(data);
            size++;
        }

    }


    private Node add(Node node, int data) {

        if (node == null) return new Node(data);
        if (data < node.data) {
            node.left = add(node.left, data);
        } else if (data > node.data) {
            node.right = add(node.right, data);
        } else {
        }
        return node;
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int getBalance(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }


}
