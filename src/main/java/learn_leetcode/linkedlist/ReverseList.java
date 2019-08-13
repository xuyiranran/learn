package learn_leetcode.linkedlist;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 206. 反转链表
 * <p>
 * 第一种解法:中规中矩的解法,遍历一次将每个节点加入到新的链表中
 * 第二种解法:遍历一次每次将链表指向反转
 */
public class ReverseList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        Queue<Integer> queue = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            queue.add(cur.val);
            cur = cur.next;
        }
        ListNode ret = null;
        while (!queue.isEmpty()) {
            ListNode addNode = new ListNode(queue.remove().intValue());
            addNode.next = ret;
            ret = addNode;
        }
        return ret;
    }


    //空间复杂度为O(1)
    public static ListNode reverseListV2(ListNode head) {
        ListNode tail = null, cur = head;
        //每走一步该变一个链表指向
        while (cur != null) {
            ListNode next = cur.next;//临时存储下一个节点
            cur.next = tail;//改变当前节点的链表指向
            tail = cur;
            cur = next;
        }
        return tail;
    }


    //比较中规中矩的方法,遍历一次将节点重新放入到一个新的链表上(插入头节点)
    public static ListNode reverseListV3(ListNode head) {
        ListNode tail = null, cur = head;
        while (cur != null) {
            tail = new ListNode(cur.val, tail);
            cur = cur.next;
        }
        return tail;
    }

    public static void print(ListNode node) {

        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

    }

    public static void main(String[] args) {


        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);

        head.next = node1;
        node1.next = node2;

        print(head);

        System.out.println();

        print(reverseListV3(head));

    }

}
