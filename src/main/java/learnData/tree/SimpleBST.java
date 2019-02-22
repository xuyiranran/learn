package learnData.tree;

public class SimpleBST {

    //根节点
    private Node root;
    private int size;
    private boolean isEmpty;

    private class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public SimpleBST(int data) {
        root = new Node(data);
        size++;
    }

    public SimpleBST() {
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
        return node;
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
        return contains(root,data);
    }

    private boolean contains(Node node,int data){
        if (node==null) return false;
        if (data==node.data)return true;
        if (data<node.data){
            return contains(node.left,data);
        }else {
            return contains(node.right,data);
        }
    }

    public int min() {
        return minNode(root).data;
    }

    private Node minNode(Node node) {

        if (node == null) throw new RuntimeException("不合法");
        if (node.left == null){
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

    private Node maxNode(Node node){

        if (node == null) throw new RuntimeException("不合法");
        if (node.right == null){
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

    public void remove(int data) {
        root=remove(root,data);
    }

    private Node remove(Node node,int data){

        if (node==null) return null;
        if (data<node.data){
            node.left=remove(node.left,data);
        } else if (data>node.data){
            node.right=remove(node.right,data);
        }else {
            if (node.left==null&&node.right==null){
                node=null;
            }
            if (node.left==null){
                Node rightNode=node.right;
                node.right=null;
            }
            if (node.right==null){
                Node minRight=minNode(node);
                minRight.right=node.right;
                node.right=null;
            }

            size--;
        }
        return node;
    }

    public static void main(String[] args) {

        SimpleBST bst = new SimpleBST(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(8);
        bst.add(13);
        bst.add(18);

        System.out.println(bst.getSize());

        bst.preOrder();

        System.out.println();
        System.out.println("max:"+bst.max());
        System.out.println("min:"+bst.min());

        System.out.println(bst.contains(15));

        bst.remove(3);
        bst.remove(8);
        bst.remove(100);

        bst.preOrder();

        System.out.println();
        System.out.println(bst.getSize());


    }


}
