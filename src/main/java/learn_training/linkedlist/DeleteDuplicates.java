package learn_training.linkedlist;

/**
 * leetcode 83:remove duplicates from sorted list
 *
 * 删除有序链表的重复元素
 */
public class DeleteDuplicates {


    private static class ListNode {

        public ListNode next;
        public int value;

        public ListNode(int value) {
            this.value = value;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //这一步是关键,当遇到重复元素的时候,cur的位置不要移动
            if (next != null && cur.value == next.value) {
                cur.next = next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);

        node2.next = node3;
        node1.next = node2;
        head.next = node1;

        toString(head);

        DeleteDuplicates deleteDuplicates=new DeleteDuplicates();

        deleteDuplicates.deleteDuplicates(head);

        System.out.println("----");
        toString(head);



    }

}
