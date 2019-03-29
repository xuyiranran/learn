package chengxuyuanmianshizhinan.stack;

/**
 * 基于链表数组实现的哈希表
 */
public class HashTable<K extends Comparable, V> {


    //链表数组,实际存储键值对的地方
    private LinkedList[] linkedLists;
    //哈希表中实际存放的键值对个数
    private int size;
    //哈希表数组长度
    private int capacity;

    public HashTable() {
        this(16);
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        linkedLists = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            linkedLists[i] = new LinkedList();
        }
    }

    //插入或更新k-v键值对
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList linkedList = linkedLists[index];
        if (linkedList.contains(key)) {
            linkedList.set(key, value);
        } else {
            linkedList.addFirst(key, value);
        }
    }

    //获取key对应的value
    public V get(K key) {
        int index = hash(key);
        LinkedList linkedList = linkedLists[index];
        return (V) linkedList.get(key);
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public static void main(String[] args) {

        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("key1", "value1");
        hashTable.put("key2", "value2");
        hashTable.put("key3", "value3");

        System.out.println(hashTable.get("key1"));
        System.out.println(hashTable.get("key2"));
        System.out.println(hashTable.get("key3"));

    }


}
