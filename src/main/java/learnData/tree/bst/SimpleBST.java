package learnData.tree.bst;

/**
 * 二分搜索树
 *
 * 基本操作:
 * 1、插入元素
 * 2、查询元素
 * 3、删除元素
 */
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
     * @param node
     * @param data
     * @return
     */
    private Node remove(Node node, int data) {

        if (node == null) return null;
        if (data<node.data){
            node.left=remove(node.left,data);
            return node;
        }
        else if (data>node.data){
            node.right=remove(node.right,data);
            return node;
        }else {
            //data==node.data
            //待删除节点左子树为空
            if (node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if (node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树都不为空
            //1、寻找出待删除节点右子树中最小节点(后继节点)/寻找出待删除节点左子树中最大节点(前驱节点)
            //2、删除右子树的最小节点/删除左子树最大节点
            //3、将后继节点或前驱节点替代待删除节点位置
            Node successor=minNode(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            //回收node节点
            node.left=node.right=null;
            return successor;
        }
    }

    public static void main(String[] args) {

        SimpleBST b=new SimpleBST(10);
        b.add(5);
        b.add(2);
        b.add(15);
        b.removeMin();

        SimpleBST bst = new SimpleBST(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(8);
        bst.add(13);
        bst.add(18);
        bst.add(4);
        bst.add(17);

        System.out.println(bst.getSize());

        bst.preOrder();
        System.out.println();

        bst.remove(3);
        bst.middleOrder();
        System.out.println();
        bst.remove(5);
        bst.middleOrder();
        System.out.println();
        bst.remove(15);
        bst.middleOrder();
        System.out.println();
        System.out.println(bst.getSize());

//        System.out.println();
//        System.out.println("max:" + bst.max());
//        System.out.println("min:" + bst.min());
//
//        System.out.println(bst.contains(15));
//
//
//        bst.preOrder();
//
//        System.out.println();
//        System.out.println(bst.getSize());
//        System.out.println("------");
//
//
//        SimpleBST simpleBST = new SimpleBST(5000);
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            simpleBST.add(random.nextInt(10000));
//        }
//
//        System.out.println(simpleBST.getSize());
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(simpleBST.removeMin());
//        }
//        list.forEach(e -> System.out.print(e + "->"));


    }


}
