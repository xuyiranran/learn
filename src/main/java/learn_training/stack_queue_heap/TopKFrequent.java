package learn_training.stack_queue_heap;

import java.util.*;

/**
 * leetcode 347:top K frequent elements
 *
 *
 * 首先使用hashmap存储元素频次
 * 使用堆维护前k个频次元素
 *
 */
public class TopKFrequent {


    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            int count=map.getOrDefault(nums[i],0);
            count++;
            map.put(nums[i],count);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));


        for (int n: map.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;

    }


}
