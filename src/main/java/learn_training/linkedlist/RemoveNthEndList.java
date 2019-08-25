package learn_training.linkedlist;

/**
 *
 */
public class RemoveNthEndList {

    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用快慢指针,但是这个边界很容易弄错
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNth(ListNode head,int n){

        if (head==null)return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode index1=dummy,index2=dummy;

        for (int i = 0; i <n+1 ; i++) {
            index1=index1.next;
        }
        while (index1!=null){
            index1=index1.next;
            index2=index2.next;
        }
        if (index2.next!=null){
            index2.next=index2.next.next;
        }
        return dummy.next;

    }


    /**
     * 扫描两趟,第一趟计算链表长度,求出需要删除的节点正序的位置
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthV2(ListNode head,int n){

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length =length- n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

}
