package learnData.code_training;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * 最近最少使用缓存淘汰策略
 */
public class LRU {

    private LinkedList<Node> linkedList = new LinkedList<>();
    private HashMap<String, Node> hashMap = new HashMap<>();
    private int limit = 0;

    private static class Node {

        private String key;
        private String value;

        public Node() {
        }

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRU(int limit) {
        this.limit = limit;
    }


    public void put(String key, String value) {

        boolean exist = hashMap.containsKey(key);
        Node newNode = new Node(key, value);
        if (!exist) {
            hashMap.put(key, newNode);
            //如果缓存满了,执行淘汰策略
            if (linkedList.size() == limit) {
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
            hashMap.put(key, newNode);
        }
    }

    public String get(String key) {

        Node node = hashMap.get(key);
        if (node == null) return null;
        //更新查询node的
        linkedList.remove(node);
        linkedList.addFirst(node);
        return node.value;
    }


    public static void main(String[] args) {

        LRU lru = new LRU(3);
        lru.put("key1", "value1");
        lru.put("key2", "value2");
        lru.put("key3", "value3");
        lru.get("key1");
        lru.put("key4", "value4");

        System.out.println(lru.get("key1"));
        System.out.println(lru.get("key4"));

    }


}
