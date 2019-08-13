package coding_interview_guide.linkedlist;

/**
 * 反转链表
 * <p>
 * 如果没有其他要求,借助栈来也可以.
 * <p>
 * 如果不能借助其他数据结构,那么直接使用指针每走一步变换指针指向.
 */
public class ReverseList {

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

    public Node reverseList(Node head) {

        if (head == null || head.next == null) return head;
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        Node first_4 = new Node(5);
        Node first_3 = new Node(first_4, 4);
        Node first_2 = new Node(first_3, 3);
        Node first_1 = new Node(first_2, 2);
        Node first = new Node(first_1, 1);

        ReverseList reverseList = new ReverseList();
        reverseList.printNode(first);
        System.out.println();
        reverseList.printNode(reverseList.reverseList(first));

    }

}
