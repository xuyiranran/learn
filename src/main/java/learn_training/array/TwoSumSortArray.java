package learn_training.array;

/**
 * 判断一个有序数组中是否存在两个元素之和等于给定值。
 * <p>
 * 通过利用有序的性质,从头尾开始渐进查询。
 */
public class TwoSumSortArray {

    public boolean exist(int[] data, int result) {
        int start = 0, end = data.length - 1;//[start,end]
        while (start < end) {
            int tmp = data[start] + data[end];
            if (tmp > result) {
                end--;
            } else if (tmp < result) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        TwoSumSortArray twoSumSortArray = new TwoSumSortArray();

        boolean exist = twoSumSortArray.exist(new int[]{0, 1, 10, 20, 30, 33}, 40);
        System.out.println(exist);

    }

}
