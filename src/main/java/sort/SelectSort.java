package sort;

/**
 * 选择排序算法
 * <p>
 * 该算法是正常人思维想出的最常规方法,具体实现
 * <p>
 * 1、第一次遍历找出最小元素放在index 0的位置
 * 2、第二次遍历剩余元素找出最小元素放到index 1的位置
 * <p>
 * 选择排序算法复杂度为O(n*n)
 * <p>
 * <p>
 * <p>
 * <p>
 * 举例:
 * 3,5,1,0
 * 第一次遍历:0,5,3,1
 * 第二次遍历:0,1,5,3
 * 第三次遍历:0,1,3,5
 * <p>
 * 自己可以一步步验证下
 * <p>
 * 如果是n个元素排序,外层循环需要n-1次,内层循环也是n-1次。
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] data = {10, 7, 3, 4, 6, 7, 1, 0, 1, 1};
        data = sort(data);
    }

    private static int[] sort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    SortUtils.swap(data, i, j);
                }
            }
            System.out.println("第" + (i + 1) + "次遍历");
            SortUtils.printArray(data);

        }
        return data;
    }


}
