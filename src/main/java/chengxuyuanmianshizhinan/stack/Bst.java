package chengxuyuanmianshizhinan.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 二分搜索树
 */
public class Bst<K extends Comparable, V> {


    //根节点
    private Node root;
    //树元素size
    private int size;

    private static class Node<K extends Comparable, V> {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }
    }

    public Bst() {
    }

    public Bst(K key, V value) {
        root = new Node(key, value);
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
            return;
        }
        root = add(root, key, value);

    }

    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = add(node.left, key, value);
        } else if (cmp > 0) {
            node.right = add(node.right, key, value);
        } else {
            //重复key
            node.value = value;
            return node;
        }
        return node;
    }

    public V remove(K key) {

        return null;
    }

    public boolean contains(K key) {
        if (isEmpty()) return false;
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

    public V min() {
        if (root == null) throw new IllegalArgumentException("空树");
        Node<K, V> cur = root;
        while (cur != null) {
            cur = cur.left;
        }
        return cur.value;
    }

    public V max() {
        if (root == null) throw new IllegalArgumentException("空树");
        Node<K, V> cur = root;
        while (cur != null) {
            cur = cur.right;
        }
        return cur.value;
    }


    public static void main(String[] args) {


        Map<Long,String> map=new HashMap<>();
        map.put(10L,"hello");
        System.out.println(map.get(10l));
        System.out.println(map.get(Long.valueOf(10l)));
        System.out.println(map.get(Long.valueOf(10)));




    }

}
