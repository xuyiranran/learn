package learnData.code_training;

import javax.print.attribute.standard.NumberUp;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheV2 {

    private HashMap<Integer, Node> hashMap = new HashMap<>();
    private int capacity = 0;
    private int size;
    private Node head, tail;

    private static class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0, null, null);
        tail = new Node(0, 0, head, null);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) return -1;
        //更新查询node的
        removeCurrentNode(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        boolean exist = hashMap.containsKey(key);
        Node newNode = new Node(key, value, null, null);
        if (!exist) {
            hashMap.put(key, newNode);
            //如果缓存满了,执行淘汰策略
            if (size >= capacity) {
                //1、删除最后一个元素
                removeLast();
                //2、添加第一个元素
                addFirst(newNode);
            } else {
                //添加到头元素
                addFirst(newNode);
                size++;
            }
        } else {
            //如果缓存中已经存在,更新缓存位置
            Node oldNode = hashMap.get(key);
            //删除当前节点
            removeCurrentNode(oldNode);
            //添加头节点
            addFirst(newNode);
            hashMap.put(key, newNode);
        }
    }

    //删除最后一个节点
    private void removeLast() {
        hashMap.remove(tail.pre.key);
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }

    private void removeCurrentNode(Node oldNode) {
        oldNode.pre.next = oldNode.next;
        oldNode.next.pre = oldNode.pre;
    }

    private void addFirst(Node newNode) {
        head.next.pre=newNode;
        newNode.next = head.next;
        newNode.pre = head;
        head.next = newNode;
    }


    public static void main(String[] args) {


        LRUCacheV2 lru = new LRUCacheV2(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);


        System.out.println(lru.get(1));
        System.out.println(lru.get(4));

        System.out.println(lru.head);

    }


}
