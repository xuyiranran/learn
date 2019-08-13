package coding_interview_guide.linkedlist;

/**
 * 删除链表中间节点
 * <p>
 * 利用快慢指针来实现
 * <p>
 * 慢指针每次走一步,快指针每次走两步.
 */
public class DeleteMiddleNode {


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

    public Node deleteMiddlerNode(Node node) {
        if (node == null || node.next == null) return node;
        if (node.next.next == null) return node.next;
        Node slow = node;
        Node fast = node.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return node;
    }

    public static void main(String[] args) {

        Node first_4 = new Node(8);
        Node first_3 = new Node(first_4, 7);
        Node first_2 = new Node(first_3, 5);
        Node first_1 = new Node(first_2, 3);
        Node first = new Node(first_1, 1);

        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
        deleteMiddleNode.printNode(first);
        System.out.println();
        deleteMiddleNode.printNode(deleteMiddleNode.deleteMiddlerNode(first));


    }

}
