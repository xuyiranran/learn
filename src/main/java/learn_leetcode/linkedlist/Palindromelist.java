package learn_leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


/**
 * 234. 回文链表
 *
 * 第一种解法:使用栈和队列存储,然后利用他们性质来比较.只需要比对一半元素即可
 * 第二种解法:将链表元素存储到数组中然后利用头尾指针来判断比较
 *
 */
public class Palindromelist {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null) return false;
        Queue<ListNode> queue = new ArrayDeque<>();
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null) {
            queue.add(cur);
            stack.push(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (queue.remove().val != stack.pop().val) {
                return false;
            }
        }
        return true;

    }


    public static boolean isPalindromeV2(ListNode head) {

        if (head == null) return false;
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode tmp=head;
        while (!stack.isEmpty()) {
            if (tmp.val != stack.pop().val) {
                return false;
            }
            tmp=tmp.next;
        }
        return true;

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(-129);
        ListNode next = new ListNode(-129);
        head.next = next;

        System.out.println(isPalindrome(head));

    }

}
