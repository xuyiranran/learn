package learn_training.linkedlist;

/**
 *
 * leetcode 328:odd even linked list
 * 奇偶链表
 * 给定一个单链表,把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 */
public class OddEvenList {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode oddEvenList(ListNode head){

        if (head==null)return head;
        ListNode odd=head,even=head.next,evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


    public static void toString(ListNode node) {

        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }

    }



}
