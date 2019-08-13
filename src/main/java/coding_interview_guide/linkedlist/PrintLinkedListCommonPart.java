package coding_interview_guide.linkedlist;

/**
 * 打印两个链表公共部分
 * <p>
 * 双指针来解决该问题
 * 完全依靠单链表的性质就可以完成,
 */
public class PrintLinkedListCommonPart {


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


    public void printCommon(Node first, Node second) {

        if (first == null || second == null) return;
        Node cur1 = first, cur2 = second;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                cur1 = cur1.next;
            } else if (cur1.value > cur2.value) {
                cur2 = cur2.next;
            } else {
                System.out.print(cur1.value + "->");
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
    }

    public static void main(String[] args) {

        Node first_4 = new Node(8);
        Node first_3 = new Node(first_4, 7);
        Node first_2 = new Node(first_3, 5);
        Node first_1 = new Node(first_2, 3);
        Node first = new Node(first_1, 1);


        Node second_4 = new Node(9);
        Node second_3 = new Node(second_4, 8);
        Node second_2 = new Node(second_3, 5);
        Node second_1 = new Node(second_2, 1);
        Node second = new Node(second_1, 0);

        PrintLinkedListCommonPart printLinkedListCommonPart = new PrintLinkedListCommonPart();

        printLinkedListCommonPart.printCommon(first, second);

    }


}
