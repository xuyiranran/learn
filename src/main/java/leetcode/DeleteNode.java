package leetcode;

public class DeleteNode {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //比较精妙的删除节点方式
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public String print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = node;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        DeleteNode deleteNode = new DeleteNode();
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(deleteNode.print(node));
        deleteNode.deleteNode(node2);
        System.out.println(deleteNode.print(node));

    }

}
