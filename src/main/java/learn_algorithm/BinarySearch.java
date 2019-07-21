package learn_algorithm;

/**
 * 二分搜索算法(对半查找)
 * <p>
 * 实现方式
 * 1、循环方式
 * 2、递归方式
 * <p>
 * 二分搜索算法实现并不难,主要可能会出错的地方是边界问题
 */
public class BinarySearch {

    /**
     * 循环方式实现的二分搜索算法
     *
     * @param data
     * @param num
     * @return
     */
    public int binarySearchWithLoop(int[] data, int num) {

        if (data.length < 1) return -1;
        int start = 0, end = data.length - 1;
        //要理解这里为什么start<=end而不是start<end,start和end是有可能相等的.比如数组长度为1的时候.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (num < data[middle]) {
                end = middle - 1;
            } else if (num > data[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    /**
     * 递归方式实现的二分搜索算法
     *
     * @param data
     * @param num
     * @return
     */
    public int binarySearchWithRecursion(int[] data, int num) {

        if (data.length == 0) return -1;
        return binarySearch(data, num, 0, data.length - 1);
    }

    private int binarySearch(int[] data, int num, int start, int end) {
        if (start > end) return -1;
        int middle = start + (end - start) / 2;
        if (num < data[middle]) {
            return binarySearch(data, num, start, middle - 1);
        } else if (num > data[middle]) {
            return binarySearch(data, num, middle + 1, end);
        } else {
            return middle;
        }
    }


    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        int[] data = new int[]{1, 2, 3, 4, 5, 6};
        int index = binarySearch.binarySearchWithLoop(data, 3);
        System.out.println(index);

        int index2 = binarySearch.binarySearchWithRecursion(data, 3);
        System.out.println(index2);


    }

}
