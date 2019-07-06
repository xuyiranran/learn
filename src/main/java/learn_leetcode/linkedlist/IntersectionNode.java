package learn_leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点
 * <p>
 * 第一种解法:将其中一个链表元素存放到HashSet中,然后循环另外一个链表查看是否存在于set集合中,如果存在就返回当前节点.
 * <p>
 * 第二种解法:先分别求出两个链表的长度,让长的那个链表先走他们长度差的距离,然后开始往下走如果碰到相同节点就返回.
 */
public class IntersectionNode {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        int lena = 0, lenb = 0;
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != null) {
            lena++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            lenb++;
            cur2 = cur2.next;
        }
        ListNode first = headA, second = headB;
        int step = 0;
        //求出长度差
        step = Math.abs(lena - lenb);
        if (lena > lenb) {
            for (int i = 0; i < step; i++) {
                first = first.next;
            }
        } else {
            for (int i = 0; i < step; i++) {
                second = second.next;
            }
        }
        //循环之道遇到两个节点相等
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }


    /**
     * 使用hashSet来判断是否存在节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode cur1 = headA, cur2 = headB;
        Set<ListNode> setA = new HashSet<>();
        while (cur1 != null) {
            setA.add(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            if (setA.contains(cur2)) {
                return cur2;
            } else {
                cur2 = cur2.next;
            }
        }
        return null;

    }


}
