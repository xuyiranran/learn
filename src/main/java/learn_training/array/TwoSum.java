package learn_training.array;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1:two sum in array
 */
public class TwoSum {


    public int[] exist(int[] array, int result) {
        int[] ret=new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] + array[j] == result){
                    ret[0]=i;
                    ret[1]=j;
                }
            }
        }
        return ret;
    }


    public int[] exist2(int[] array, int result) {
        int[] ret=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i],i);
        }
        for (int i = 0; i <array.length ; i++) {
            Integer j=map.getOrDefault(result-array[i],null);
            if (j!=null&&j!=i){
                ret[0]=i;
                ret[1]=j;
            }
        }
        return ret;
    }

}
