package learn_data_structure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * <p>
 * 二分搜索树在满足二叉树的前提下,还需要满足任何节点的左孩子小于父亲节点,右孩子大于父亲节点.所有节点元素都是可比较的.
 */
public class SimpleBST {

    private Node root;
    private int size;

    private static class Node {
        //左右子节点
        private Node left, right;
        //节点元素
        private int value;
        //这里可以定义其它的节点元素

        public Node(Node left, int value, Node right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
        public Node(int value) {
            this(null, value, null);
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
        //递归条件(转化为更小问题)
        int cmp = value - node.value;
        if (cmp < 0) {
            node.left = addNode(node.left, value);
        } else if (cmp > 0) {
            node.right = addNode(node.right, value);
        } else {
            //cmp==0不做任何处理
        }
        return node;
    }


    //查询是否包含元素
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        //递归退出条件
        if (node == null) return false;
        if (node.value == value) return true;

        //递归条件
        int cmp = value - node.value;
        if (cmp < 0) {
            return contains(node.left, value);
        }
        if (cmp > 0) {
            return contains(node.right, value);
        }
        return false;
    }


    //返回bst最小元素
    public int min() {
        if (isEmpty()) throw new IllegalArgumentException("bst is empty");
        return min(root).value;
    }

    private Node min(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return min(node.left);
    }

    //查询最小元素非递归写法
    private Node minNR(Node node) {
        if (node == null) return null;
        Node cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return node;
    }

    //返回bst最大元素
    public int max() {
        if (isEmpty()) throw new IllegalArgumentException("bst is empty");
        return max(root).value;
    }

    private Node max(Node node) {
        if (node == null) return null;
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    //查询最大元素非递归写法
    private Node maxNR(Node node) {
        if (node == null) return null;
        Node cur = node;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    //删除bst最小元素
    public int removeMin() {
        int min = min();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {

        //递归退出条件
        if (node == null) return null;
        if (node.left == null) {
            Node rightNode = node.right;
            size--;
            node.right = null;//删除引用,让GC回收.
            return rightNode;
        }

        //递归条件
        node.left = removeMin(node.left);
        return node;
    }


    //删除bst最大元素
    public int removeMax() {
        int max = max();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {

        //递归退出条件
        if (node == null) return null;
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            node.right = null;//删除引用,让GC回收.
            return leftNode;
        }

        //递归条件
        node.right = removeMax(node.right);
        return node;
    }


    //删除bst任意一个元素
    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node node, int value) {

        //递归退出条件
        if (node == null) return null;
        if (node.value == value) {
            if (node.left == null) {
                size--;
                return node.right;
            }
            if (node.right == null) {
                size--;
                return node.left;
            }
            Node rightMinNode = min(node.right);
            Node leftNode = node.left;
            rightMinNode.right = removeMin(node.right);//由于这里已经size-1了,所以下面就不需要再进行size-1了.
            rightMinNode.left = leftNode;
            node.left = null;
            node.right = null;
            return rightMinNode;

        }

        //递归条件
        //向左继续递归
        if (value < node.value) {
            node.left = remove(node.left, value);
        }
        //向右继续递归
        if (value > node.value) {
            node.right = remove(node.right, value);
        }
        return node;
    }


    //二叉树深度优先遍历的三种遍历方式:先序遍历、中序遍历、后序遍历
    //三种遍历方式使用递归写法比较简单易实现,当然也可以使用非递归实现,代码会更复杂.

    //先序遍历(又称深度优先)
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;

        //访问节点元素
        System.out.print(node.value + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归实现先序遍历
    public void preOrderNR() {

        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);//首先先将根节点入栈

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.value + "->");//访问节点
            //由于先序遍历是先访问左子树后访问右子树的,根据栈后进先出的特性,先入栈右子树然后入栈左子树.
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    //中序遍历(结果是排序后的列表)
    public void middleOrder() {
        middleOrder(root);
    }

    private void middleOrder(Node node) {
        if (node == null) return;

        middleOrder(node.left);
        //访问节点元素
        System.out.print(node.value + "->");
        middleOrder(node.right);
    }

    //后序遍历(有些场景会使用到,比如内存管理中的内存释放策略)
    public void afterOrder() {
        afterOrder(root);
    }

    private void afterOrder(Node node) {
        if (node == null) return;

        afterOrder(node.left);
        afterOrder(node.right);
        //访问节点元素
        System.out.print(node.value + "->");
    }


    //二叉树的广度优先遍历(使用队列数据结构来完成,这里不好使用递归方式实现)
    public void leverOrder() {
        if (root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            //访问节点元素
            System.out.print(cur.value + "->");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }


    public static void main(String[] args) {

        SimpleBST bst = new SimpleBST();

        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(2);
        bst.add(2);
        bst.add(7);
        bst.add(13);
        bst.add(20);


        bst.preOrder();
        System.out.println();
        bst.middleOrder();
        System.out.println();
        bst.afterOrder();
        System.out.println("\r\n先序遍历非递归实现");
        bst.preOrderNR();


        System.out.println("\r\n广度优先遍历");
        bst.leverOrder();


//        System.out.println("remove max" + bst.removeMax());
//        System.out.println("remove max" + bst.removeMax());
//        System.out.println("remove min" + bst.removeMin());

        bst.remove(5);
        bst.remove(15);
        System.out.println();


        bst.middleOrder();
    }


}
