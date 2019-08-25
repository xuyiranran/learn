package learn_training.find;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1:two sum
 *
 *
 *
 */
public class TwoSum {


    /**
     * 直接使用两层循环来处理
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] result=new int[2];
        for (int i = 0; i <nums.length-1 ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return result;
    }


    /**
     * 使用hashmap来处理
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV2(int[] nums, int target) {

        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i <nums.length-1 ; i++) {
            int ret=target-nums[i];
            Integer tmp=map.getOrDefault(ret,-1);
            if (tmp>-1&&tmp!=i){
                return new int[]{i,tmp};
            }
        }
        return result;
    }

}
