package learn_data_structure;

import java.util.*;

/**
 * 最近使用频率最少淘汰策略
 */
public class LFU {

    private int size = 0;
    private int capacity = 0;
    private Map<String, String> data = new HashMap<>();
    private Map<String, Integer> keyCountMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<String>> countMap = new HashMap<>();
    private int minCounter;

    public LFU(int capacity) {
        this.capacity = capacity;
    }

    public void put(String key, String value) {
        if (data.keySet().size() >= capacity) {
            removeCache();
        }
        if (data.keySet().contains(key)) {
            //更新频次
            int count = keyCountMap.getOrDefault(key, 1);
            keyCountMap.put(key, count + 1);
            //删除旧的count记录，添加新的count记录
            countMap.get(count).iterator().remove();
            LinkedHashSet<String> linkedHashSet = countMap.getOrDefault(count + 1, new LinkedHashSet<>());
            linkedHashSet.add(key);
            countMap.put(count + 1, linkedHashSet);
        } else {
            data.put(key, value);
            //由于新进来一个元素那么这个minCounter必然是1
            minCounter = 1;
            LinkedHashSet<String> linkedHashSet = countMap.getOrDefault(minCounter, new LinkedHashSet<>());
            linkedHashSet.add(key);
            countMap.put(minCounter, linkedHashSet);
            keyCountMap.put(key, minCounter);
        }
    }

    public String get(String key) {
        //如果不包含key
        if (!data.keySet().contains(key)) return null;
        int count = keyCountMap.getOrDefault(key, 0);
        if (count == minCounter) {
            minCounter++;
        }
        keyCountMap.put(key, count + 1);
        countMap.get(count).remove(key);
        LinkedHashSet<String> linkedHashSet = countMap.getOrDefault(count + 1, new LinkedHashSet<>());
        linkedHashSet.add(key);
        countMap.put(count + 1, linkedHashSet);
        return data.get(key);
    }

    private void removeCache() {
        LinkedHashSet<String> hashSet = countMap.get(minCounter);
        Iterator<String> iterator = hashSet.iterator();
        String removeKey = null;
        if (iterator.hasNext()) {
            removeKey = iterator.next();
        }
        if (removeKey != null) hashSet.remove(removeKey);
        data.remove(removeKey);
        keyCountMap.remove(removeKey);
    }


    public static void main(String[] args) {

        LFU lfu = new LFU(4);
        lfu.put("hello1", "value1");
        lfu.put("hello2", "value2");
        lfu.put("hello3", "value3");
        lfu.put("hello4", "value4");

        System.out.println(lfu.data);
        System.out.println(lfu.get("hello1"));
        System.out.println(lfu.get("hello2"));
        System.out.println(lfu.get("hello3"));
        System.out.println(lfu.get("hello4"));

        lfu.put("test", "value");

        System.out.println(lfu.data);

    }


}
