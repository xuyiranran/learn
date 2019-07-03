package learn_leetcode.linkedlist;

/**
 * 合并两个有序的链表
 */
public class MergeLinkedList {

    static class Node {
        public Node next;
        public int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

    private static String printNode(Node root) {
        return getString(root);
    }

    private static String getString(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = root;
        while (cur != null) {
            stringBuilder.append(cur.value + "->");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    public static Node merge(Node left, Node right) {

        Node head = null, tail = null;
        Node curLeft = left;
        Node curRight = right;
        while (curLeft != null && curRight != null) {
            if (curLeft.value <= curRight.value) {
                if (head == null) {
                    head =tail= new Node(curLeft.value);
                } else {
                    tail.next = new Node(curLeft.value);
                    tail = tail.next;
                }
                curLeft = curLeft.next;
            } else {
                if (head == null) {
                    head = tail=new Node(curRight.value);
                } else {
                    tail.next = new Node(curRight.value);
                    tail = tail.next;
                }
                curRight = curRight.next;
            }
        }
        if (curLeft == null) {
            tail.next = curRight;
        } else if (curRight == null) {
            tail.next = curLeft;
        } else {
            //do nothing
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

        System.out.println(getString(left));
        System.out.println(getString(right));

        Node head = merge(left, right);
        System.out.println(getString(head));
    }

}
