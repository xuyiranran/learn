package learnData.tree.bst;

public class CommonBST<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int size;

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public CommonBST(K key, V value) {
        root = new Node<>(key, value);
        size++;
    }

    public CommonBST() {
    }

    public void add(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            size++;
        }
    }

    public V remove() {
        return null;
    }

    public boolean contains(K key) {
        return false;
    }

    public V get(K key) {
        return null;
    }

    public void set(K key, V value) {

    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
