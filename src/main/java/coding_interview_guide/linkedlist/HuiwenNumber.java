package coding_interview_guide.linkedlist;

import java.util.Stack;

/**
 * 判断一个链表是否是回文树
 *
 * 1、基于栈实现
 * 2、可以只存一半的元素,然后和栈的元素比较
 */
public class HuiwenNumber {


    private static class Node {
        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public void printNode(Node node) {

        Node cur = node;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }

    }


    public boolean isHuiwenNumber(Node node) {

        if (node == null) return false;
        Stack<Integer> stack = new Stack<>();
        Node cur = node;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }
        while (node != null) {
            if (stack.pop() != node.value) {
                return false;
            }
            node = node.next;
        }
        return true;

    }

    public static void main(String[] args) {

        HuiwenNumber huiwenNumber = new HuiwenNumber();

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        node1.next = node2;
        node.next = node1;

        boolean flag = huiwenNumber.isHuiwenNumber(node);
        System.out.println(flag);

    }


}
