package offer;

/**
 * 二维数组中的查找(从左到右升序、从上到下升序)
 */
public class Solution01 {


    public boolean Find(int target, int[][] array) {
        int lows = array.length;
        int cols = array[0].length;
        for (int i = 0; i < lows; i++) {
            for (int j = 0; j < cols; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }

        }
        return false;
    }


    public boolean FindFast(int target, int[][] array) {
        int lows = array.length;
        int cols = array[0].length;
        int i = 0;
        int j = cols - 1;
        while (i < lows && j >= 0) {

            if (target > array[i][j]) {
                i++;
            } else if (target < array[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {


    }


}
