package chengxuyuanmianshizhinan.stack.second_linkedlist;

/**
 * 删除链表倒数第kth元素
 * <p>
 * 1->2->3->4  kth=3
 * 2  1  0 -1  与-1对应的1的位置节点删除
 * <p>
 * 1->2->3->4  kth=4
 * 3  2  1  0  刚好就是删除头节点
 * <p>
 * 1->2->3->4  kth=5
 * 4  3  2  1  不合法
 *
 *
 */
public class RemoveLastKth {

    private static class Node {

        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node removeLastKth(Node head, int lastKth) {

        if (lastKth < 1 || head == null) return head;
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            return head.next;
        }
        if (lastKth < 0) {
            Node pre = head;
            lastKth++;
            while (lastKth < 0) {
                pre = pre.next;
                lastKth++;
            }
            pre.next = pre.next.next;
        }
        return head;
    }
}
