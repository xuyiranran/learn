package learnData.hash;

import java.util.HashMap;
import java.util.TreeMap;

public class HashTable<K extends String, V> {

    private TreeMap<K, V>[] treeMaps;

    //哈希表中元素个数
    private int size;
    //哈希表数组长度
    private int arrayCapacity;

    private static final int DEFAULT_CAPACITY = 10;

    public HashTable() {
        treeMaps = new TreeMap[DEFAULT_CAPACITY];
        arrayCapacity = DEFAULT_CAPACITY;
        for (int i = 0; i < treeMaps.length; i++) {
            treeMaps[i] = new TreeMap<>();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 插入k-v键值对
     *
     * @param k
     * @param v
     */
    public void add(K k, V v) {

        if (size > 2 * arrayCapacity) {
            resize(2 * arrayCapacity + 1);
        }
        int index = hash(k);
        treeMaps[index].put(k, v);
        size++;
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @return
     */
    public V get(K key) {
        int index = hash(key);
        TreeMap<K, V> treeMap = treeMaps[index];
        return treeMap.getOrDefault(key, null);
    }

    /**
     * 更新key对应的值
     *
     * @param key
     * @param v
     */
    public void set(K key, V v) {
        int index = hash(key);
        TreeMap<K, V> treeMap = treeMaps[index];
        if (!treeMap.containsKey(key)) {
            throw new IllegalArgumentException("不存在指定key");
        }
        treeMap.put(key, v);
    }

    /**
     * 删除指定key
     *
     * @param key
     * @return
     */
    public V delete(K key) {
        if (arrayCapacity > 2 * size && arrayCapacity > DEFAULT_CAPACITY) {
            resize(arrayCapacity / 2);
        }
        int index = hash(key);
        TreeMap<K, V> treeMap = treeMaps[index];
        if (!treeMap.containsKey(key)) {
            throw new IllegalArgumentException("不存在指定key");
        }
        V remove = treeMap.remove(key);
        size--;
        return remove;
    }

    /**
     * 扩容与缩容
     *
     * @param newArrayCapacity
     */
    private void resize(int newArrayCapacity) {

        //需要暂存下,下面要使用
        int oldArrayLength = arrayCapacity;
        this.arrayCapacity = newArrayCapacity;

        TreeMap<K, V>[] newTreeMaps = new TreeMap[newArrayCapacity];
        for (int i = 0; i < newTreeMaps.length; i++) {
            newTreeMaps[i] = new TreeMap<>();
        }

        for (int i = 0; i < oldArrayLength; i++) {
            TreeMap<K, V> treeMap = treeMaps[i];
            for (K k : treeMap.keySet()) {
                int index = hash(k);
                newTreeMaps[index].put(k, treeMap.get(k));
            }
        }
        treeMaps = newTreeMaps;
    }

    private int hash(K k) {
        return Math.abs(k.hashCode()) % arrayCapacity;
    }


    public static void main(String[] args) {

        HashTable<String, String> hashTable = new HashTable<>();
        for (int i = 0; i < 20; i++) {
            hashTable.add("" + i, "" + i);
        }

        hashTable.add("hello", "hello");
        hashTable.add("hello1", "hello1");
        hashTable.add("hello2", "hello2");
        hashTable.add("hello3", "hello3");

        System.out.println(hashTable.get("hello"));
        System.out.println(hashTable.get("3"));

    }

}
