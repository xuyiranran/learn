package learn_training.linkedlist;

/**
 * leetcode 206:reverse linked list反转链表
 *
 * 这题的解题思路需要在纸上画出三个指针指向,才能清晰的写出代码。
 *
 *
 */
public class ReverseList {

    private static class Node{

        public Node next;
        public int value;

        public Node(int value){
            this.value=value;
        }

    }

    public Node reverseList(Node head){

        if (head.next==null||head==null)return head;
        Node cur=head;
        Node pre=null;
        while (cur!=null){
            Node next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public static void toString(Node node){

        Node cur=node;
        while (cur!=null){
            System.out.print(cur.value+"->");
            cur=cur.next;
        }

    }

    public static void main(String[] args) {

        Node head=new Node(1);

        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);

        node2.next=node3;
        node1.next=node2;
        head.next=node1;

        toString(head);

        ReverseList reverseList=new ReverseList();

        Node result=reverseList.reverseList(head);

        toString(result);




    }

}
