package coding_interview_guide.linkedlist;

public class DeleteLastKthNode {

    private static class Node {
        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public void printNode(Node node) {

        Node cur = node;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }

    }

    public Node deleteLastKthNode(Node node, int kth) {
        int len = 0;
        Node cur = node;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (kth < 0 || kth > len) {
            throw new IllegalArgumentException("不合法下标");
        }
        if (kth == len) {
            node = node.next;
            return node;
        }
        Node pre = node;
        int index = len - kth - 1;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        return node;
    }

    public static void main(String[] args) {

        Node first_4 = new Node(8);
        Node first_3 = new Node(first_4, 7);
        Node first_2 = new Node(first_3, 5);
        Node first_1 = new Node(first_2, 3);
        Node first = new Node(first_1, 1);

        DeleteLastKthNode deleteLastKthNode = new DeleteLastKthNode();
        deleteLastKthNode.printNode(first);
        System.out.println("");
        deleteLastKthNode.printNode(deleteLastKthNode.deleteLastKthNode(first,5));

    }

}
