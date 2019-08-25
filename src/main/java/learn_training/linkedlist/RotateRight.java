package learn_training.linkedlist;

/**
 *
 *  leetcode 61:rotate list
 *
 *
 *
 */
public class RotateRight {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode rotateRight(ListNode head,int k){

        if (head==null||head.next==null)return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        int len=0;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        int lastIndex=k%len;
        if (lastIndex==0)return head;
        int index=len-lastIndex;
        while (index>0){
            dummy=dummy.next;
            index--;
        }
        ListNode newNode=dummy.next;
        dummy.next=null;
        ListNode tmp=newNode;
        while (tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=head;
        return newNode;
    }


    public static void main(String[] args) {

    }

}
