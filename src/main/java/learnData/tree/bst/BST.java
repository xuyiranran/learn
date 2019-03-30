package learnData.tree.bst;


/**
 * 二分搜索树实现
 *
 * 限制:插入元素必须是可比较的
 *
 * 方法:
 * 1、插入节点
 * 2、查询节点
 * 3、删除节点
 * 4、遍历树(前序遍历、中序遍历、后序遍历)
 * 5、深度优先和广度优先
 *
 *
 */
public class BST<E extends Comparable<E>> {

    //根节点
    private Node<E> root;

    private int size;

    /**
     * 节点定义
     * 组成:节点元素、左孩子、右孩子
     *
     * @param <E>
     */
    private class Node<E> {

        private E e;
        private Node<E> left;
        private Node<E> right;

        public Node(E e) {
            this.e = e;
        }
    }

    public BST(E e) {
        root = new Node<>(e);
        size++;
    }

    public BST() {
    }

    /**
     * 增加节点
     *
     * @param e
     */
    public void add(E e) {

        if (root == null) {
            root = new Node<>(e);
            size++;
            return;
        }
        if (root.e.compareTo(e) == 0) {
            return;
        }
        if (e.compareTo(root.e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(root.e) > 0 && root.right == null) {
            root.right = new Node<>(e);
            size++;
            return;
        }
        add(root, e);

    }

    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            node = new Node<>(e);
            size++;
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left=add(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right=add(node.right, e);
            return node;
        }
        return node;
    }

    public E max(){
        return max(root);
    }

    private E max(Node<E> node){
        if (isEmpty()){
            throw new RuntimeException("空树");
        }
        if (node.right==null){
            return node.e;
        }
        return max(node.right);
    }

    public E min(){
        return min(root);
    }

    private E min(Node<E> node){
        if (isEmpty()){
            throw new RuntimeException("空树");
        }
        if (node.left==null){
            return node.e;
        }
        return min(node.left);
    }

    public void remove(E e){

        if (isEmpty()){
            throw new RuntimeException("空树");
        }
        root=remove(root,e);

    }

    private Node<E> remove(Node<E> node,E e){

        if (node==null){
            throw new RuntimeException("空树");
        }
        if (e.compareTo(node.e)==0){
            //需要删除的节点
            size--;
            if (node.left==null)return node.right;
            if (node.right==null)return node.left;
            node.e=min(node.right);
            node.right=remove(node.right,e);
        }
        if (e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
        }
        if (e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
        }
        return node;
    }


    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node<E> node,E e){
        if (node==null)return false;
        if (e.compareTo(node.e)==0)return true;
        if (e.compareTo(node.e)<0){
            return contains(node.left,e);
        }
        if (e.compareTo(node.e)>0){
            return contains(node.right,e);
        }
        return false;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e.toString());
        preOrder(node.left);
        preOrder(node.right);

    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node<E> node) {
        if (node == null) return;
        midOrder(node.left);
        System.out.println(node.e.toString());
        midOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void afterOrder(){
        afterOrder(root);
    }

    private void afterOrder(Node<E> node){
        if (node==null)return;
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.e.toString());
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        bst.add(50);
        bst.add(25);
        bst.add(100);
        bst.add(12);
        bst.add(40);
        bst.add(80);
        bst.add(150);
        bst.add(1);
        bst.add(15);
        bst.add(70);
        System.out.println(bst.getSize());
        System.out.println(bst.isEmpty());

        System.out.println("tree max:"+bst.max());

        System.out.println("tree min:"+bst.min());

        System.out.println("tree contains 100:"+bst.contains(100));
        System.out.println("tree contains 33:"+bst.contains(33));
        bst.remove(1);
        bst.remove(12);
        bst.midOrder();

    }


}
