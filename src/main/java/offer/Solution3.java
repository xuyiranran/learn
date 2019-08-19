package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *
 * 该题本质想考察的是反转链表
 * 1、可以直接通过递归来求解
 * 2、借助栈数据结构
 */
public class Solution3 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        ListNode cur=listNode;
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }

        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {

        Solution3 solution3=new Solution3();

        ListNode listNode=new ListNode(0);

        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);

        listNode2.next=listNode3;
        listNode1.next=listNode2;
        listNode.next=listNode1;

        System.out.println(solution3.printListFromTailToHead(listNode));
        System.out.println("end");


    }


}
