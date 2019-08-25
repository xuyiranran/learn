package learn_training.linkedlist;

import java.util.Stack;

/**
 * leetcode 234:palindrome linked list(判断是否回文链表)
 *
 *
 * 解题思路
 * 1、使用一个栈数据结构来存储链表数据是一种常规思路
 * 2、反转链表再比较
 */
public class PalindromeList {


    private static class ListNode {

        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }

    }


    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (head != null) {
            if (stack.pop() != head.val) return false;
            head = head.next;
        }
        return stack.isEmpty();
    }


}
