package learn_training.find;

import java.util.*;

/**
 *
 *
 * leetcode 15:three sum
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 *
 *
 */
public class ThreeSum {


    /**
     * 直接使用三层for循环处理
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        Set<String> sets=new HashSet<>();
        for (int i = 0; i <nums.length-2 ; i++) {
            for (int j = i+1; j <nums.length-1 ; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        int[] ret=new int[]{nums[i],nums[j],nums[k]};
                        Arrays.sort(ret);
                        StringBuffer sb=new StringBuffer();
                        for (int l = 0; l <ret.length ; l++) {
                            sb.append(Math.abs(ret[l]));
                        }
                        if (!sets.contains(sb.toString())){
                            List<Integer> tmp=new ArrayList<>();
                            tmp.add(nums[i]);tmp.add(nums[j]);tmp.add(nums[k]);
                            result.add(tmp);
                            sets.add(sb.toString());
                        }
                    }
                }
            }
        }
        return result;
    }



    /**
     * 先排序再搜索
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumV2(int[] nums) {

        return null;
    }



    public static void main(String[] args) {


        ThreeSum threeSum=new ThreeSum();

        List<List<Integer>> result=threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println(result);

    }


}
