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

        public Node left;//左节点
        public Node right;//右节点
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

    //添加元素
    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node node, int value) {
        //递归退出条件
        if (node == null) {
            size++;
            return new Node(value);
        }
        //递归条件
        int cmp = value - node.value;
        if (cmp <= 0) {
            node.left = addNode(node.left, value);
        } else {
            node.right = addNode(node.right, value);
        }
        return node;
    }

    //判断是否包含节点
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        //递归退出条件
        if (node == null) return false;
        int cmp = value - node.value;
        if (cmp == 0) return true;
        //递归条件
        if (cmp < 0) {
            return contains(node.left, value);
        }
        if (cmp > 0) {
            return contains(node.right, value);
        }
        return false;
    }

    public void remove(int value) {
        root = removeNode(root, value);
    }

    public void removeMin() {
        removeMin(root);
    }

    private Node removeMin(Node node) {
        //递归退出条件
        if (node == null) return null;
        if (node.left == null) {
            Node rightNode = node.right;
            size--;
            return rightNode;
        }
        //递归条件
        node.left = removeMin(node.left);
        return node;
    }


    public void removeMax() {
        removeMax(root);
    }

    private Node removeMax(Node node) {
        //递归退出条件
        if (node == null) return null;
        if (node.right == null) {
            Node leftNode = node.left;
            size--;
            return leftNode;
        }
        //递归条件
        node.right = removeMax(node.right);
        return node;
    }


    //二叉搜索树种最小元素
    public int getMin() {
        if (root == null) throw new IllegalArgumentException("树为空");
        return minNode(root).value;
    }

    //子树最小节点
    private Node minNode(Node node) {
        //递归退出条件
        if (node == null) return node;
        if (node.left == null) return node;

        //递归条件
        return minNode(node.left);
    }


    public int getMax() {
        if (root == null) throw new IllegalArgumentException("树为空");
        return maxNode(root).value;
    }

    //子树最大子节点
    private Node maxNode(Node node) {

        if (node == null) return null;
        if (node.right == null) return node;
        return maxNode(node.right);

    }

    private Node removeNode(Node node, int value) {

        if (node == null) return null;
        int cmp = value - node.value;
        if (cmp < 0) {
            node.left = removeNode(node.left, value);
        } else if (cmp > 0) {
            node.right = removeNode(node.right, value);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            }
            if (node.right == null) {
                size--;
                return node.left;
            }
            {
                //顺序很重要
                Node minRightNode = minNode(node.right);
                minRightNode.right = removeMin(node.right);//这一步一定要下面这步先执行
                minRightNode.left = node.left;
                node.left = null;
                node.right = null;
                return minRightNode;
            }
        }
        return node;
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


        bst.remove(10);
        System.out.println(bst.toString());

        System.out.println(bst.size);

    }


}