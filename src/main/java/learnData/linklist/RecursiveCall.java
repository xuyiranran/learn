package learnData.linklist;

/**
 * 递归调用
 */
public class RecursiveCall {

    public static void main(String[] args) {

        System.out.println(sum(100));

        int[] arr = new int[]{1, 2, 3,4,5};
        System.out.println(sum(arr));
    }

    private static int sum(int n) {
        int sum;
        if (n == 0) {
            return 0;
        }
        sum = n + sum(n - 1);
        return sum;
    }

    private static int sum(int[] arr){
        return sum(arr,arr.length);
    }

    private static int sum(int[] arr, int length) {
        int sum;
        if (length == 0) {
            return 0;
        }
        sum = arr[length - 1] + sum(arr, length - 1);
        return sum;
    }

}
