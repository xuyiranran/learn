package learn_leetcode.linkedlist;

/**
 *
 * 876. 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 *
 * [1,2,3,4,5]->[3,4,5]
 * [1,2,3,4,5,6]->[4,5,6]
 *
 *
 * 使用快慢指针来处理
 */
public class MiddleNode {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode middleNode(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) return head.next;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }


}
