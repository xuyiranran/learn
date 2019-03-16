package learnData.tree.redblack;

/**
 * 红黑树的实现
 * <p>
 * <p>
 * 重点:学习红黑树最好先深入理解2-3树，因为红黑树是基于2-3的原理实现的,它们可以理解为等价关系.
 *
 * @param <K>
 * @param <V>
 */
public class RedBlackTree<K extends Comparable<K>, V> {


    //根节点
    private Node root;
    private int size;


    public RedBlackTree() {
    }

    //节点红黑属性标识
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node<K extends Comparable<K>, V> {

        private K key;
        private V value;

        private Node left, right;
        private boolean color;

        public Node(K key, V value) {
            this(key, value, RED);
        }
        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 增加元素
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    private Node add(Node<K, V> node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value, RED);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = add(node.left, key, value);
        } else if (cmp > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        //节点右边为红色节点需要调整
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        //左斜双红节点链
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        //左右节点都是红色节点需要调整
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    //交换节点颜色
    private void flipColors(Node node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }


    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node) {

        Node x = node.left;
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 判断节点是否是红节点
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        if (node == null) return BLACK;
        return node.color;
    }

    public static void main(String[] args) {


        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.add(new Integer(5), "test");
        redBlackTree.add(new Integer(2), "test");
        redBlackTree.add(new Integer(15), "test");
//        redBlackTree.add(new Integer(20), "test");
//        redBlackTree.add(new Integer(30), "test");
        redBlackTree.add(new Integer(10), "10value");


        System.out.println(redBlackTree.root.left.key);
        System.out.println(redBlackTree.root.right.value);

    }

}
