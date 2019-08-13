package learn_data_structure.tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.Random;

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
//                Node left = node.left;
//                LL(node, left);
//                updateHeight(node);
//                updateHeight(left);
//                return left;
                return LL(node);
            }
            //LR
            if (node.left.right != null) {
//                Node x = node;
//                Node y = node.left;
//                Node z = node.left.right;
//                Node t1 = x.right;
//                Node t2 = y.left;
//                Node t3 = z.left;
//                Node t4 = z.right;
//                z.left = y;
//                z.right = x;
//                y.left = t2;
//                y.right = t3;
//                x.left = t4;
//                x.right = t1;
//                updateHeight(x);
//                updateHeight(y);
//                updateHeight(z);
                node.left = RR(node.left);
                return LL(node);

//                return z;
            }
        } else if (balance < -1) {
            //RR
            if (node.right.right != null) {
//                Node rightNode = node.right;
//                RR(node, rightNode);
//                updateHeight(node);
//                updateHeight(rightNode);
//                return rightNode;
                return RR(node);
            }
            //RL
            if (node.right.left != null) {

//                Node x = node;
//                Node y = node.right;
//                Node z = node.right.left;
//
//                Node t1 = x.left;
//                Node t2 = y.right;
//                Node t3 = z.left;
//                Node t4 = z.right;
//
//                z.left = x;
//                z.right = y;
//                x.left = t1;
//                x.right = t3;
//                y.left = t4;
//                y.right = t2;
//                updateHeight(x);
//                updateHeight(y);
//                updateHeight(z);

                node.right = LL(node.right);
                return RR(node);
//                return z;

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
        if (node == null) return;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }


    private Node LL(Node node) {
        Node y = node.left;
        Node t1 = y.right;
        node.left = t1;
        y.right = node;
        updateHeight(node);
        updateHeight(y);
        return y;
    }

    private Node RR(Node node) {

        Node y = node.right;
        Node t1 = y.left;
        node.right = t1;
        y.left = node;
        updateHeight(node);
        updateHeight(y);
        return y;
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
            return node;
        } else if (cmp > 0) {
            node.right = removeNode(node.right, value);
            return node;
        } else {
            Node result;
            //删除操作
            size--;
            if (node.left == null) {
                result = node.right;
            } else if (node.right == null) {
                result = node.left;
            } else {
                Node leftNode = node.left;
                Node rightMinNode = removeMin(node.right);
                rightMinNode.left = leftNode;
                node.left = node.right = null;
                result = rightMinNode;
                size++;
            }
            if (result == null) return null;
            //获取当前节点的平衡因子
            result.height = getHeight(result);
            int balance = getBalance(result);
            //如果balance>1表示左斜
            if (balance > 1) {
                //LL
                if (result.left.left != null) {
//                    Node y = result.left;
//                    Node t3 = y.right;
//                    y.right = result;
//                    result.left = t3;
//                    return y;

                    return LL(result);
                }
                //LR
                if (result.left.right != null) {
//                    Node x = result;
//                    Node y = result.left;
//                    Node z = result.left.right;
//                    Node t1 = x.right;
//                    Node t2 = y.left;
//                    Node t3 = z.left;
//                    Node t4 = z.right;
//                    z.left = y;
//                    z.right = x;
//                    y.left = t2;
//                    y.right = t3;
//                    x.left = t4;
//                    x.right = t1;
//                    updateHeight(x);
//                    updateHeight(y);
//                    updateHeight(z);
//                    return z;
                    result.left = RR(result.left);
                    return LL(result);
                }

            } else if (balance < -1) {

                if (result.right.right != null) {
//                    Node y = result.right;
//                    Node t2 = y.left;
//                    result.right = t2;
//                    y.left = result;
//                    return y;
                    return RR(result);
                }
                if (result.right.left != null) {
//                    Node x = result;
//                    Node y = result.right;
//                    Node z = result.right.left;
//                    Node t1 = x.left;
//                    Node t2 = y.right;
//                    Node t3 = z.left;
//                    Node t4 = z.right;
//                    z.left = x;
//                    z.right = y;
//                    x.left = t1;
//                    x.right = t3;
//                    y.left = t4;
//                    y.right = t2;
//                    updateHeight(x);
//                    updateHeight(y);
//                    updateHeight(z);
//                    return z;
                    result.right = LL(node.right);
                    return RR(result);
                }
            } else {
                updateHeight(result);
            }
            return result;
        }
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

        Random random = new Random(Integer.MAX_VALUE);
        for (int i = 0; i < 100; i++) {
            avl.add(i);
        }


        System.out.println(avl.root.value);
        System.out.println(avl.root.right.value);
        avl.middleOrder();
        System.out.println();
        System.out.println(avl.isBst());
        System.out.println(avl.isBalanceTree());
        System.out.println("size:" + avl.size);

        System.out.println("===============");
        for (int i = 0; i < 30; i++) {
            avl.remove(i);
        }

        System.out.println(avl.root.value);
        System.out.println(avl.root.right.value);
        avl.middleOrder();
        System.out.println();
        System.out.println(avl.isBst());
        System.out.println(avl.isBalanceTree());
        System.out.println("size:" + avl.size);

    }

}
