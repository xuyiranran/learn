package offer;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个结点
 * 该问题有多种解法
 * 1、使用两个指针
 * 2、计算出倒数第k个是整数第几个
 *
 * 双指针效率会高一些
 */
public class Solution14 {


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {

        // 输入的链表不能为空，并且k大于0
        if (k < 1 || head == null) {
            return null;
        }
        ListNode first=head;
        ListNode second=head;
        for (int i = 0; i < k-1; i++) {
            if (first.next!=null){
                first=first.next;
            }else {
                return null;
            }
        }
        while (first.next!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }



    public static void main(String[] args) {

    }

}
