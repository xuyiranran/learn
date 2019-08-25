package learn_training.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 82:remove duplicates from sorted list
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 该题我还没给出最优解
 */
public class DeleteDuplicatesV2 {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }


    public ListNode remove(ListNode head) {

        if (head == null || head.next == null) return head;
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                map.put(cur.val, true);
            }
            cur = cur.next;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode start = dumy;
        while (start.next != null) {
            if (map.getOrDefault(start.next.val, false)) {
                start.next = start.next.next;
            } else {
                start = start.next;
            }
        }
        return dumy.next;
    }


}
