package learn_training.linkedlist;

/**
 * leetcode 21:merge two sorted lists
 * <p>
 * 合并两个有序链表
 *
 *
 * 因为两个链表都是有序的,可以通过两个指针分别往下走比对。
 */
public class MergeSortList {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }


    public ListNode mergeSortList(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode left = l1, right = l2;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = new ListNode(left.val);
                dummy = dummy.next;
                left = left.next;
            } else {
                dummy.next = new ListNode(right.val);
                dummy=dummy.next;
                right = right.next;
            }
        }
        if (left==null){
            dummy.next=right;
        }else {
            dummy.next=left;
        }
        return dummyHead.next;


    }

}
