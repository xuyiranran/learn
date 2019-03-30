package chengxuyuanmianshizhinan.stack.second_linkedlist;

/**
 * 打印链表共同部分
 * <p>
 * 算法思路:费别从head1和head2开始开始比较
 * 循环条件为head1和head2都不为空
 * 1、如果head1大于head2,那么head2往后移动一位
 * 2、如果head1小于head2,那么head1往后移动一位
 * 3、如果head1等于head2,那么head1和head2都往后移动一位
 */
public class PrintCommonPart {

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {//如果head1小于head2,head1往后移动一位
                head1 = head1.next;
            } else if (head1.data > head2.data) {//如果head1大于head2,head2往后移动一位
                head2 = head2.next;
            } else {//head1和head2相同
                System.out.print(head1.data + "->");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }


    public static void main(String[] args) {

        PrintCommonPart printCommonPart = new PrintCommonPart();
        Node head1 = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        Node head2 = new Node(3, new Node(4, new Node(5, new Node(6, null))));
        printCommonPart.printCommonPart(head1, head2);

    }
}
