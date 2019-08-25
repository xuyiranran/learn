package learn_training.find;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 219:contains duplicate II
 *
 */
public class ContainsNearbyDuplicate {


    /**
     *
     * 维护一个hashset存储k个元素
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }

}
