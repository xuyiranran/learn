package learn_training.linkedlist;

import java.util.HashSet;

/**
 * leetcoe 141&142:cycle linked list环形链表判断
 *
 * 判断链表中是否存在环
 *
 * 1、可以使用快慢指针,如果链表存在环,那么慢指针肯定会追到快指针的
 * 2、可以使用hashset存储已经遍历过的节点,当出现hashset中已经存在的节点表明存在环
 *
 */
public class CycleLInkedLIst {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * 基于快慢指针实现
     * @param head
     * @return
     */
    public boolean cycle(ListNode head){
        if (head==null||head.next==null)return false;
        ListNode slow=head,fast=head.next;

        while (fast!=null&&fast.next!=null){
            if (slow==fast)return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }


    /**
     * 基于hashset实现
     * @param head
     * @return
     */
    public boolean cycleV2(ListNode head){
        if (head==null||head.next==null)return false;
        HashSet<ListNode> hashSet=new HashSet<>();
        ListNode cur=head;
        while (cur!=null){
            if (hashSet.contains(cur))return true;
            hashSet.add(cur);
            cur=cur.next;
        }
        return false;
    }



}
