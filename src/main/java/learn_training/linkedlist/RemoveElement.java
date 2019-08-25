package learn_training.linkedlist;

/**
 * leetcode 203:remove linked list elements
 */
public class RemoveElement {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode cur=dumy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dumy.next;
    }


    public static void toString(ListNode node) {

        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);

//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);

//        node2.next = node3;
//        node1.next = node2;
//        head.next = node1;

        toString(head);
        System.out.println();

        RemoveElement removeElement=new RemoveElement();

        ListNode result=removeElement.removeElements(head,1);
        toString(result);


    }


}
