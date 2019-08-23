package learn_training.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * leetcode 215:kth largeth element in array
 * <p>
 * 1、常规解法使用快速排序算法先排序,后查询。算法复杂度NlogN
 * 2、优化解法使用维护一个K大小的堆。时间复杂度NlogK
 */
public class KthLargestElement {


    /**
     * 使用快速排序算法先排序,然后直接返回结果
     *
     * @param data
     * @param kth
     * @return
     */
    public int kthLargestV1(int[] data, int kth) {
        Arrays.sort(data);
        return data[kth - 1];
    }

    public int kthLargestV2(int[] data, int kth) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(kth);
        for (int i = 0; i < data.length; i++) {
            queue.add(data[i]);
        }
        return queue.peek();
    }


}
