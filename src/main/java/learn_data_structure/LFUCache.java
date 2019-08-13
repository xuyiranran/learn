package learn_data_structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {


    private int size = 0;
    private int capacity = 0;
    private Map<Integer, Integer> data = new HashMap<>();
    private Map<Integer, Integer> keyCountMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> countMap = new HashMap<>();
    private int minCounter;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if (capacity <= 0) return -1;
        //如果不包含key
        if (!data.keySet().contains(key)) return -1;
        int count = keyCountMap.getOrDefault(key, 0);
        if (count == minCounter && countMap.getOrDefault(count, new LinkedHashSet<>()).size() == 1) {
            minCounter++;
        }
        keyCountMap.put(key, count + 1);
        countMap.get(count).remove(key);
        LinkedHashSet<Integer> linkedHashSet = countMap.getOrDefault(count + 1, new LinkedHashSet<>());
        linkedHashSet.add(key);
        countMap.put(count + 1, linkedHashSet);
        return data.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (data.keySet().size() >= capacity && !data.keySet().contains(key)) {
            removeCache();
        }
        if (data.keySet().contains(key)) {
            //更新频次
            int count = keyCountMap.getOrDefault(key, 1);
            keyCountMap.put(key, count + 1);
            //删除旧的count记录，添加新的count记录

            LinkedHashSet<Integer> oldLinkedHashSet = countMap.getOrDefault(count, new LinkedHashSet<>());
            oldLinkedHashSet.remove(key);
            LinkedHashSet<Integer> linkedHashSet = countMap.getOrDefault(count + 1, new LinkedHashSet<>());
            linkedHashSet.add(key);
            countMap.put(count + 1, linkedHashSet);
            data.put(key, value);
        } else {
            data.put(key, value);
            //由于新进来一个元素那么这个minCounter必然是1
            minCounter = 1;
            LinkedHashSet<Integer> linkedHashSet = countMap.getOrDefault(minCounter, new LinkedHashSet<>());
            linkedHashSet.add(key);
            countMap.put(minCounter, linkedHashSet);
            keyCountMap.put(key, minCounter);
        }
    }

    private void removeCache() {
        LinkedHashSet<Integer> hashSet = countMap.get(minCounter);
        Iterator<Integer> iterator = hashSet.iterator();
        Integer removeKey = null;
        if (iterator.hasNext()) {
            removeKey = iterator.next();
        }
        if (removeKey != null) hashSet.remove(removeKey);
        data.remove(removeKey);
        keyCountMap.remove(removeKey);
    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(2);
        cache.put(2, 6);
        cache.put(1, 1);
        cache.put(1, 2);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));


    }


}
