package sort;

public class BinarySearch {


    public static void main(String[] args) {

        int arr[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
    }


    /**
     * 非递归实现二分查找
     *
     * @param sortArray
     * @param data
     * @return
     */
    private static boolean containsV1(int[] sortArray, int data) {
        int start = 0, end = sortArray.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data > sortArray[mid]) {
                start = mid + 1;
            } else if (data < sortArray[mid]) {
                end = mid - 1;
            } else return true;
        }
        return false;
    }


    private static boolean contains(int[] sortArray, int data) {
        return contains(sortArray, 0, sortArray.length - 1, data);
    }

    /**
     * 递归实现二分查找
     *
     * @param sortArray
     * @param begin
     * @param end
     * @param data
     * @return
     */
    private static boolean contains(int[] sortArray, int begin, int end, int data) {
        if (begin > end) return false;
        int middle = (begin + end) / 2;
        if (data > sortArray[middle]) {
            return contains(sortArray, middle + 1, end, data);
        } else if (data < sortArray[middle]) {
            return contains(sortArray, begin, middle - 1, data);
        } else {
            return true;
        }
    }


}
