package learnData.linklist;

import java.util.List;

public class MainApp {


    static class ListNode {
        public int value;
        public ListNode next = null;

        public ListNode() {
        }

        public ListNode(int data) {
            this.value = data;
        }

        @Override
        public String toString() {
            return value + "";
        }

        void print() {
            System.out.print(value + " ");
            if (next != null) {
                next.print();
            }
        }
    }

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);


        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(12);
        head2.next.next.next = new ListNode(13);
        head2.next.next.next.next = new ListNode(15);
        head = mergeSortedLists2(head, head2);

        print(head);


//        //1. head2插在head1和head1tmp中间
//        ListNode head3 = new ListNode(1);
//        head3.next = new ListNode(6);
//        head3.next.next = new ListNode(7);
//
//        ListNode head4 = new ListNode(2);
//        head4.next = new ListNode(3);
//        head4.next.next = new ListNode(4);


    }

    private static void print(ListNode root) {

        ListNode cur = root;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
    }

    private static ListNode mergeSortedLists2(ListNode head1, ListNode head2) {


        if (head1.value < head2.value) {
            ListNode cur1 = head1;
            while (cur1.next != null && cur1 != null && cur1.value <= head2.value) {
                cur1 = cur1.next;
            }
            //head1小于head2场景
            if (cur1.next == null) {
                cur1.next = head2;
            } else {

                ListNode cur2 = head2;
                while (cur2 != null && cur2.value < cur1.value) {
                    cur2 = cur2.next;
                }
                if (cur2.next == null) {
                    cur2.next = cur1;
                } else {
                    cur1.next = cur2.next;
                    cur2.next = cur1;
                }
            }
            return cur1;
        } else {
            ListNode cur2 = head2;
            while (cur2 != null && cur2.value <= head1.value) {
                cur2 = cur2.next;
            }
            if (cur2.next == null) {
                cur2.next = head1;
            } else {

            }
            return cur2;
        }
    }

}
