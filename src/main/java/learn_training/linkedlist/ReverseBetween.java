package learn_training.linkedlist;

/**
 * leetcode 92:reverse linked list II反转链表指定范围(m-n)
 */
public class ReverseBetween {


    private static class ListNode {

        public ListNode next;
        public int value;

        public ListNode(int value) {
            this.value = value;
        }

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        int index = 0;
        while (cur!=null){
            index++;
            if (index>=m&&index<=n){
                ListNode next= cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }else {
                pre.next=cur;
                cur=cur.next;
            }
        }
        return pre;
    }


    public static void toString(ListNode node) {

        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node2.next = node3;
        node1.next = node2;
        head.next = node1;

        toString(head);

        ReverseBetween reverseBetween = new ReverseBetween();

        ListNode result=reverseBetween.reverseBetween(head, 1, 2);
        System.out.println();
        toString(result);
    }
}
