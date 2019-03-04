package learnData.code_training;

public class Bst {

    //根节点
    private Node root;
    //元素个数
    private int size;

    private static class Node {

        private int data;
        private Node left, right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Bst() {
    }

    public Bst(int rootData) {
        this.root = new Node(rootData);
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int data) {

        //如果树为空
        if (root == null) {
            root = new Node(data);
            size++;
        }
        root = addNode(root, data);

    }

    private Node addNode(Node node, int data) {
        if (node == null) {
            size++;
            return new Node(data);
        }
        if (data < node.data) {
            node.left = addNode(node.left, data);
        } else if (data > node.data) {
            node.right = addNode(node.right, data);
        } else {
            //do nothing
        }
        return node;
    }


    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Node node, int data) {
        if (node == null) return false;
        if (data < node.data) {
            return contains(node.left, data);
        } else if (data > node.data) {
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    public void remove(int data) {

        if (!contains(data)) {
            throw new RuntimeException("不存在key");
        }
        remove(root, data);


    }

    private Node remove(Node node, int data) {

        if (data < node.data) {
            node.left = remove(node.left, data);
            return node;
        } else if (data > node.data) {
            node.right = remove(node.right, data);
            return node;
        } else {
            //寻找到节点
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                return right;
            } else if (node.right == null) {

                Node left = node.left;
                node.left = null;
                return left;
            } else {
                //左右节点都不为空
                node.data = min(node.right).data;
                node.right = remove(node.right, node.data);
                return node;
            }
        }
    }


    public int max() {
        if (root == null) {
            throw new RuntimeException("空树");
        }
        return max(root).data;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public int min() {
        if (root == null) {
            throw new RuntimeException("空树");
        }
        return min(root).data;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }


    public static void main(String[] args) {

        Bst bst = new Bst(10);
        bst.add(5);
        bst.add(15);
        bst.add(16);
        bst.add(1);
        System.out.println(bst.getSize());
        System.out.println(bst.root.right.right.data);

        System.out.println(bst.max());
        System.out.println(bst.min());

    }

}
