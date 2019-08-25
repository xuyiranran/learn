package learn_training.linkedlist;

import java.util.HashSet;

/**
 *
 * leetcoe 141&142:cycle linked list环形链表判断
 *
 * 参考:https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
 *
 *
 */
public class CycleLinkedListV2 {

    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * 使用hashset存储已遍历的节点
     * @param head
     * @return
     */
    public ListNode cycle(ListNode head){

        HashSet<ListNode> hashSet=new HashSet<>();
        ListNode cur=head;
        while (cur!=null){
            if (hashSet.contains(cur))return cur;
            hashSet.add(cur);
            cur=cur.next;
        }
        return null;
    }


    /**
     * 使用快慢指针让他们遇见
     * @param head
     * @return
     */
    public ListNode cycleV2(ListNode head){

        if (head==null||head.next==null)return null;
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
                return slow;
            }
        }
        return null;
    }


}
