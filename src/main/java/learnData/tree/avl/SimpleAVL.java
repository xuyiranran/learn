package learnData.tree.avl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * AVL树
 * 平衡二叉树
 * 1、满足所有任意节点的左右子树高度差不大于1
 * <p>
 * 基本操作:
 * 1、插入元素
 * 2、查询元素
 * 3、删除元素
 */
public class SimpleAVL {

    //根节点
    private Node root;
    private int size;
    private boolean isEmpty;

    private class Node {
        private int data;
        private Node left, right;
        private int height = 1;//节点高度,叶子节点高度为1

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    public SimpleAVL(int data) {
        root = new Node(data);
        size++;
    }

    public SimpleAVL() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int data) {
        root = add(root, data);
    }

    /**
     * 查询节点高度
     *
     * @param node
     * @return
     */
    public int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    /**
     * 判断一棵树是否是二分搜索树
     * 基于二分搜索树中序遍历是升序的原理,我们可以利用此来判断
     *
     * @param node
     * @return
     */
    private boolean isBST(Node node) {

        if (node == null) return true;
        List<Integer> list = new ArrayList<>();
        middleOrder(node, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }

    /**
     * 中序遍历并将节点元素存放在list中
     *
     * @param node
     * @param list
     */
    private void middleOrder(Node node, List<Integer> list) {
        if (node == null) return;
        middleOrder(node.left, list);
        list.add(node.data);
        middleOrder(node.right, list);
    }

    /**
     * 判断节点是否满足AVL要求
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {
        if (node == null) return true;
        if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) return false;
        return true;
    }

    private int getBalanceFactor(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node add(Node node, int data) {
        if (node == null) {
            size++;
            return new Node(data);
        }
        if (data < node.data) {
            node.left = add(node.left, data);
        } else if (data > node.data) {
            node.right = add(node.right, data);
        } else {
            //我们这里不处理相同元素 所以什么事情都不做
        }

        //更新node height
        node.height = getNodeHeight(node);

        //获取平衡因子
        int balance = getBalanceFactor(node);

        //左斜树LL 右旋转操作
        if (balance > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        //右斜树RR 左旋转操作
        if (balance < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        //LR
        if (balance > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL
        if (balance < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 左旋转操作
     * #=================================================================================================================#
     * #                                                                                                                 #
     * #               x                                      y                  #                                       #
     * #             /  \                                  /   \                 #          y.right=x                    #
     * #           y    T4                               z       x               #          x.left=T3                    #
     * #         /  \            ====>                 / \     /  \              #                                       #
     * #        z   T3                               T1  T2  T3    T4            #          x==>update height            #
     * #      /  \                                                               #          y==>update height            #
     * #     T1   T2                                                             #                                       #
     * #                                                                         #                                       #
     * #                                                                         #                                       #
     * #=================================================================================================================#
     * y节点会作为新的根节点返回
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        Node x = node;
        Node y = node.left;

        //旋转交换节点
        Node T3 = y.right;
        y.right = x;
        x.left = T3;

        //更新有移动的x和y的高度
        x.height = getNodeHeight(x);
        y.height = getNodeHeight(y);
        return y;
    }

    /**
     * 右旋转操作
     * #=================================================================================================================#
     * #                                                                      #                                          #
     * #       x                              y                               #            x.right=T2                    #
     * #     /  \                           /  \                              #            y.left=x                      #
     * #  T1     y                         x    z                             #                                          #
     * #        / \          ===>        / \   / \                            #            x===>update height            #
     * #     T2    z                    T1 T2 T3  T4                          #            y===>update height            #
     * #          / \                                                         #                                          #
     * #        T3  T4                                                        #                                          #
     * #                                                                      #                                          #
     * #                                                                      #                                          #
     * #                                                                      #                                          #
     * #                                                                      #                                          #
     * #=================================================================================================================#
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node;
        Node y = node.right;

        Node T2 = y.left;

        x.right = T2;
        y.left = x;
        x.height = getNodeHeight(x);
        y.height = getNodeHeight(y);
        return y;
    }


    private int getNodeHeight(Node x) {
        return Math.max(getHeight(x.left), getHeight(x.right)) + 1;
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
        preOrder(node.left);
        System.out.print(node.data + "-->");
        preOrder(node.right);
    }

    public void afterOrder() {
        middleOrder(root);
    }

    private void afterOrder(Node node) {
        if (node == null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.data + "-->");
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Node node, int data) {
        if (node == null) return false;
        if (data == node.data) return true;
        if (data < node.data) {
            return contains(node.left, data);
        } else {
            return contains(node.right, data);
        }
    }

    public int min() {
        return minNode(root).data;
    }

    private Node minNode(Node node) {

        if (node == null) throw new RuntimeException("空树");
        if (node.left == null) {
            return node;
        } else {
            return minNode(node.left);
        }

        //非递归写法
//        while (node.left!=null){
//            node=node.left;
//        }
//        return node;
    }


    public int max() {
        return maxNode(root).data;
    }

    private Node maxNode(Node node) {

        if (node == null) throw new RuntimeException("空树");
        if (node.right == null) {
            return node;
        } else {
            return maxNode(node.right);
        }

        //非递归写法
//        while (node.right!=null){
//            node=node.right;
//        }
//        return node;
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    public int removeMin() {
        int result = min();
        root = removeMin(root);
        return result;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public int removeMax() {
        int result = max();
        root = removeMax(root);
        return result;

    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(int data) {
        root = remove(root, data);
    }

    /**
     * 删除任意元素
     *
     * @param node
     * @param data
     * @return
     */
    private Node remove(Node node, int data) {

        Node result;
        if (node == null) return null;
        if (data < node.data) {
            node.left = remove(node.left, data);
            return node;
        } else if (data > node.data) {
            node.right = remove(node.right, data);
            return node;
        } else {
            //data==node.data
            //待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                result = rightNode;
            }
            //待删除节点右子树为空
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                result = leftNode;
            } else {
                //待删除节点左右子树都不为空
                //1、寻找出待删除节点右子树中最小节点(后继节点)/寻找出待删除节点左子树中最大节点(前驱节点)
                //2、删除右子树的最小节点/删除左子树最大节点
                //3、将后继节点或前驱节点替代待删除节点位置
                Node successor = minNode(node.right);
                successor.right = remove(node.right, successor.data);
                successor.left = node.left;
                //回收node节点
                node.left = node.right = null;
                result = successor;
            }

            if (result == null) return null;

            //更新node height
            result.height = getNodeHeight(result);

            //获取平衡因子
            int balance = getBalanceFactor(result);

            //左斜树LL 右旋转操作
            if (balance > 1 && getBalanceFactor(result.left) >= 0) {
                return leftRotate(result);
            }

            //右斜树RR 左旋转操作
            if (balance < -1 && getBalanceFactor(result.right) <= 0) {
                return rightRotate(result);
            }

            //LR
            if (balance > 1 && getBalanceFactor(result.left) < 0) {
                result.left = leftRotate(result.left);
                return rightRotate(result);
            }

            //RL
            if (balance < -1 && getBalanceFactor(result.right) > 0) {
                result.right = rightRotate(result.right);
                return leftRotate(result);
            }
            return result;
        }
    }

    public static void main(String[] args) {


        SimpleAVL bst = new SimpleAVL(1);

        bst.add(1525110487);
        bst.add(530246935);



        Random random = new Random(1000);

        for (int i = 0; i < 100000; i++) {
            int data=random.nextInt(Integer.MAX_VALUE);
            System.out.println(data);
            bst.add(data);
        }

        System.out.println(bst.isBalanced(bst.root));
        System.out.println(bst.root.height);

//        bst.add(5);
//        bst.add(3);
//        bst.add(1);
//
//
//        System.out.println(bst.isBST(bst.root));
//        System.out.println(bst.isBalanced(bst.root));
//        System.out.println(bst.getSize());
//
//        System.out.println(bst.root.data);
//        System.out.println(bst.root.left.data);
//        System.out.println(bst.root.left.left.data);
//        System.out.println("height");
//        System.out.println(bst.root.height);
//        System.out.println(bst.root.left.height);
//        System.out.println(bst.root.left.left.height);
//        System.out.println(bst.root.right.height);


//        bst.add(2);
//        bst.add(3);
//        bst.add(4);
//        bst.add(5);
//        bst.add(10);
//
//        System.out.println(bst.getSize());
//        System.out.println(bst.isBalanced(bst.root));
//        System.out.println(bst.root.data);
//        System.out.println(bst.root.left.data);
//        System.out.println(bst.root.right.data);
//
//        bst.remove(3);
//        bst.remove(2);
//        bst.remove(5);
//
//        System.out.println(bst.isBalanced(bst.root));
//        System.out.println(bst.size);


    }


}
