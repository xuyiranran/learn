package learnData.code_training;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheV1 {

    private java.util.LinkedList<Node> linkedList = new LinkedList<>();
    private java.util.HashMap<Integer, Node> hashMap = new HashMap<>();
    private int capacity = 0;

    private static class Node {
        private int key;
        private int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCacheV1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) return -1;
        //更新查询node的
        linkedList.remove(node);
        linkedList.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {

        boolean exist = hashMap.containsKey(key);
        Node newNode = new Node(key, value);
        if (!exist) {
            hashMap.put(key, newNode);
            //如果缓存满了,执行淘汰策略
            if (linkedList.size() == capacity) {
                Node removeNode = linkedList.getLast();
                linkedList.removeLast();
                hashMap.remove(removeNode.key);
                linkedList.addFirst(newNode);
            } else {
                linkedList.addFirst(newNode);
            }
        } else {
            //如果缓存中已经存在,更新缓存位置
            Node oldNode = hashMap.get(key);
            linkedList.remove(oldNode);
            linkedList.addFirst(newNode);
            hashMap.put(key,newNode);
        }
    }


}
