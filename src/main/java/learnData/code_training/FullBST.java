package learnData.code_training;

/**
 *
 */
public class FullBST<K extends Comparable, V> {


    private Node<K, V> root;
    private int size;

    private static class Node<K extends Comparable, V> {

        private K key;
        private V value;
        private int nums;
        private Node<K, V> left, right;

        public Node(K key, V value, int nums) {
            this.key = key;
            this.nums = nums;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public FullBST() {
    }

    public int getSize() {
        return size;
    }

    private int nums(Node node) {
        if (node == null) return 0;
        return node.nums;
    }

    public void add(K key, V value) {

        if (root == null) {
            root = new Node(key, value, 1);
            root.nums = 1;
            size++;
            return;
        }
        root = add(root, key, value);
    }

    public Node add(Node<K, V> node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = add(node.left, key, value);
        } else if (cmp > 0) {
            node.right = add(node.right, key, value);
        } else {
            //do nothing
        }
        node.nums = nums(node.left) + nums(node.right) + 1;
        return node;
    }

    public V delete(K key) {
        V value = get(key);
        root = delete(root, key);
        return value;
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
            return node;
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
            return node;
        } else {
            size--;
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node<K, V> min = min(node.right);
            min.left = node.left;
            min.right = delete(node.right, min.key);
//            node.right = delete(node.right, min.key);
            node.nums = nums(node.left) + nums(node.right) + 1;
            return min;
        }
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("不合法的key");
        Node<K, V> node = get(root, key);
        if (node == null) throw new IllegalArgumentException("不存在指定key");
        return node.value;
    }

    private Node<K, V> get(Node<K, V> node, K key) {

        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public void middleOrder() {
        middlePrint(root);
    }

    private void middlePrint(Node node) {
        if (node == null) return;
        middlePrint(node.left);
        System.out.print("->" + node.value + ":" + node.nums);
        middlePrint(node.right);

    }


    public V min() {
        return min(root).value;
    }

    private Node<K, V> min(Node<K, V> node) {
        if (node == null) throw new IllegalArgumentException("空节点");
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public V max() {
        return max(root).value;
    }

    private Node<K, V> max(Node<K, V> node) {

        if (node == null) throw new IllegalArgumentException("空节点");
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }


    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node node, K key) {

        if (node == null) return false;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return contains(node.left, key);
        } else if (cmp > 0) {
            return contains(node.right, key);
        } else {
            return true;
        }
    }


    public static void main(String[] args) {


        FullBST<Integer, String> fullBST = new FullBST();
        fullBST.add(10, "10");
        fullBST.add(5, "5");
        fullBST.add(6, "6");
        fullBST.add(4, "4");
        fullBST.add(15, "15");
        fullBST.add(13, "13");
        fullBST.add(20, "20");


        System.out.println(fullBST.size);

        fullBST.middleOrder();
        System.out.println("---");
        fullBST.middleOrder();

        System.out.println();

        fullBST.delete(15);
        System.out.println(fullBST.size);
        System.out.println("---");
        fullBST.middleOrder();


    }


}
