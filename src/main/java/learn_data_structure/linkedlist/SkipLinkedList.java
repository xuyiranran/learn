package learn_data_structure.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * 跳跃表实现
 */
public class SkipLinkedList {


    private static class SkipListNode {

        private int value;
        private List<SkipListNode> nextNodes;

        public SkipListNode(int value) {

            this.value = value;
            this.nextNodes = new LinkedList<>();
        }

        public int getValue() {
            return value;
        }
    }

    private SkipListNode head;
    private int maxLevel;
    private int size;

    private static final double PROBABILITY = 0.5;

    public SkipLinkedList() {
        size = 0;
        maxLevel = 0;
        // a SkipListNode with value null marks the beginning
        head = new SkipListNode(-1);
        // null marks the end
        head.nextNodes.add(null);
    }

    public SkipListNode getHead() {
        return head;
    }

    // Adds e to the skiplist.
    // Returns false if already in skiplist, true otherwise.
    public boolean add(int value) {
        if (contains(value)) return false;
        size++;
        // random number from 0 to maxLevel+1 (inclusive)
        int level = 0;
        while (Math.random() < PROBABILITY)
            level++;
        while (level > maxLevel) { // should only happen once
            head.nextNodes.add(null);
            maxLevel++;
        }
        SkipListNode newNode = new SkipListNode(value);
        SkipListNode current = head;
        do {
            current = findNext(value, current, level);
            newNode.nextNodes.add(0, current.nextNodes.get(level));
            current.nextNodes.set(level, newNode);
        } while (level-- > 0);
        return true;
    }

    // Returns the skiplist node with greatest value <= e
    private SkipListNode find(int value) {
        return find(value, head, maxLevel);
    }

    // Returns the skiplist node with greatest value <= e
    // Starts at node start and level
    private SkipListNode find(int value, SkipListNode current, int level) {
        do {
            current = findNext(value, current, level);
        } while (level-- > 0);
        return current;
    }

    // Returns the node at a given level with highest value less than e
    private SkipListNode findNext(int value, SkipListNode current, int level) {
        SkipListNode next = current.nextNodes.get(level);
        while (next != null) {

            if (value < next.getValue()) // e < value
                break;
            current = next;
            next = current.nextNodes.get(level);
        }
        return current;
    }

    public int size() {
        return size;
    }

    public boolean contains(int value) {
        SkipListNode node = find(value);
        return node.value == value;
    }


    public static void main(String[] args) {

        SkipLinkedList skipLinkedList=new SkipLinkedList();
        skipLinkedList.add(1);
        skipLinkedList.add(2);
        skipLinkedList.add(3);


        System.out.println(skipLinkedList.maxLevel);
    }

}
