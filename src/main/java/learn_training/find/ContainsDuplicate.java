package learn_training.find;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * leetcode 217:contains duplicate I
 *
 *
 */
public class ContainsDuplicate {


    /**
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

}
