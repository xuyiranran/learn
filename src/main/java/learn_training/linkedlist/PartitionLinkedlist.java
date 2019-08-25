package learn_training.linkedlist;

/**
 *
 * leetcode 86:partition list
 *
 * 参考:https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode/
 *
 *
 *
 */
public class PartitionLinkedlist {

    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode partitionLinkedlist(ListNode head, int x){

        ListNode before=new ListNode(-1);
        ListNode beforeHead=before;
        ListNode after=new ListNode(-1);
        ListNode afterHead=after;
        ListNode cur=head;
        while (cur!=null){
            if (cur.val<x){
                before.next=cur;
                before=before.next;
            }else {
                after.next=cur;
                after=after.next;
            }
            cur=cur.next;
        }
        after.next=null;
        before.next=afterHead.next;
        return beforeHead.next;
    }

    public static void toString(ListNode node) {

        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }

    }







}
