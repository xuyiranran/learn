package chengxuyuanmianshizhinan.stack.second_linkedlist;

import learnData.array.Stack;

/**
 * 反转链表
 */
public class ReverseList {

    private static class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this(data, null);
        }

    }

    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;//临时存储下一个节点
            head.next = pre;//将head指向
            pre = head;
            head = next;
        }
        return pre;
    }

    public String toString(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.data + "->");
            node = node.next;
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        ReverseList reverseList = new ReverseList();
        Node node = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        node.next = second;
        second.next = third;
        third.next = four;

        System.out.println(reverseList.toString(node));
        Node head = reverseList.reverseList(node);
        System.out.println(reverseList.toString(head));


    }

}
