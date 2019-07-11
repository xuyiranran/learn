package learn_data_structure.tree;

/**
 * avl平衡二叉树
 * <p>
 * 平衡二叉树的性质
 * 1、满足二叉搜索树性质
 * 2、任何及诶单左右子树高度差不超多1
 */
public class AVL {


    private Node root;
    private int size;

    private static class Node {

        public Node left, right;
        public int value;
        public int height;

        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.height = 1;
        }

        public Node(int value) {
            this(null, null, value);
        }
    }

    public AVL() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) return false;
        int cmp = value - node.value;
        if (cmp < 0) {
            return contains(node.left, value);
        } else if (cmp > 0) {
            return contains(node.right, value);
        } else {
            return true;
        }
    }

    public boolean isBst() {
        return isBstNode(root);
    }

    private boolean isBstNode(Node node) {
        if (node == null) return true;
        return isBstNode(node.left) && isBstNode(node.right);
    }


    public boolean isBalanceTree() {
        return isBalanceNode(root);
    }

    private boolean isBalanceNode(Node node) {
        if (node == null) return true;
        return Math.abs(getBalance(node.left)) <= 1 && Math.abs(getBalance(node.right)) <= 1;
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node node, int value) {
        if (node == null) {
            size++;
            return new Node(value);
        } else {
            int cmp = value - node.value;
            if (cmp < 0) {
                node.left = addNode(node.left, value);
            } else if (cmp > 0) {
                node.right = addNode(node.right, value);
            } else {
                // do nothing
            }
        }
        //获取当前节点的平衡因子
        int balance = getBalance(node);
        //如果balance>1表示左斜
        if (balance > 1) {
            //LL
            if (node.left.left != null) {
                Node left = node.left;
                LL(node, left);
                updateHeight(node);
                updateHeight(left);
                return left;
            }
            //LR
            if (node.left.right != null) {

            }
        } else if (balance < -1) {
            //RR
            if (node.right.right != null) {
                Node rightNode = node.right;
                RR(node, rightNode);
                updateHeight(node);
                updateHeight(rightNode);
                return rightNode;
            }
            //RL
            if (node.right.left != null) {

                Node y=node.left;
                Node z=y.right;
                RR(y,z);
                updateHeight(y);
                updateHeight(z);


            }
        } else {
            //不需要旋转,但是需要更新节点高度
            updateHeight(node);
        }
        return node;
    }


    private void LL(Node node, Node leftNode) {
        node.left = leftNode.right;
        leftNode.right = node;
    }

    private void RR(Node node, Node rightNode) {
        node.right = rightNode.left;
        rightNode.left = node;
    }

    private void updateHeight(Node node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int min() {
        if (root == null) throw new IllegalArgumentException("空树");
        return minNode(root).value;
    }

    private Node minNode(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return minNode(node.left);
    }

    public int max() {
        if (root == null) throw new IllegalArgumentException("空树");
        return maxNode(root).value;
    }

    private Node maxNode(Node node) {
        if (node == null) return null;
        if (node.right == null) return node;
        return maxNode(node.right);
    }


    public int removeMin() {
        if (root == null) throw new IllegalArgumentException("空树");
        int min = min();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            size--;
            return node;
        } else {
            node.left = removeMin(node.left);
        }
        return node;
    }


    public int removeMax() {
        if (root == null) throw new IllegalArgumentException("空树");
        int max = max();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            size--;
            return node;
        } else {
            node.right = removeMax(node.right);
        }
        return node;
    }

    public void remove(int value) {
        if (root == null) throw new IllegalArgumentException("空树");
        root = removeNode(root, value);
    }

    private Node removeNode(Node node, int value) {
        if (node == null) return null;
        int cmp = value - node.value;
        if (cmp < 0) {
            node.left = removeNode(node.left, value);
        } else if (cmp > 0) {
            node.right = removeNode(node.right, value);
        } else {
            //删除操作
            size--;
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node leftNode = node.left;
            Node rightMinNode = removeMin(node.right);
            rightMinNode.left = leftNode;
            node.left = node.right = null;
            return rightMinNode;
        }
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void middleOrder() {
        middleOrder(root);
    }

    private void middleOrder(Node node) {
        if (node == null) return;
        middleOrder(node.left);
        System.out.print(node.value + "->");
        middleOrder(node.right);
    }


    public void afterOrder() {
        afterOrder(root);
    }

    private void afterOrder(Node node) {
        if (node == null) return;
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.print(node.value + "->");
    }


    public static void main(String[] args) {


        AVL avl = new AVL();
        avl.add(1);
        avl.add(2);
        avl.add(3);
        avl.add(4);
        avl.add(5);

        System.out.println(avl.root.value);
        System.out.println(avl.root.right.value);
        avl.middleOrder();
        System.out.println();
        System.out.println(avl.isBst());
        System.out.println(avl.isBalanceTree());
    }

}
