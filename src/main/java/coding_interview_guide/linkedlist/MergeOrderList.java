package coding_interview_guide.linkedlist;

/**
 * 合并两个有序链表
 */
public class MergeOrderList {


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

    public Node mergeList(Node first, Node second) {


        if (first == null) return second;
        if (second == null) return first;

        Node head1 = first;
        Node head2 = second;
        Node head = null, tail = null;

        while (head1 != null && head2 != null) {
            if (head1.value >= head2.value) {
                if (head == null) {
                    head = tail = new Node(head2.value);
                    head.next = tail;
                } else {
                    tail.next = new Node(head2.value);
                    tail = tail.next;
                }
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                if (head == null) {
                    head = tail = new Node(head1.value);
                    head.next = tail;
                } else {
                    tail.next = new Node(head1.value);
                    tail = tail.next;
                }
                head1 = head1.next;
            }
        }
        if (head1 == null) {
            tail.next = head2;
        }
        if (head2 == null) {
            tail.next = head1;
        }
        return head;
    }


    public static void main(String[] args) {


        Node left = new Node(1);
        Node left2 = new Node(2);
        Node left3 = new Node(5);
        left.next = left2;
        left2.next = left3;

        Node right = new Node(4);
        Node right2 = new Node(5);
        Node ritht3 = new Node(10);
        right.next = right2;
        right2.next = ritht3;


        MergeOrderList mergeOrderList = new MergeOrderList();
        Node root = mergeOrderList.mergeList(left, right);
        mergeOrderList.printNode(root);

    }


}
