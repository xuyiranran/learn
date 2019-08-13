package learn_leetcode.linkedlist;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public static void print(ListNode node) {

        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        print(head);
        System.out.println();
        print(swapPairs(head));

    }
}
