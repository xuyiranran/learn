package learn_training.linkedlist;

/**
 * leetcode 24:swap nodes in pairs
 */
public class SwapPairs {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }


    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

}
