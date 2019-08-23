package learn_training.array;

/**
 * leetcode 1:two sum in array
 */
public class TwoSum {


    public boolean exist(int[] array, int result) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == result) return true;
            }
        }
        return false;
    }

}
