package learn_algorithm;

import java.util.Arrays;

/**
 * 排序
 * <p>
 * n*n算法复杂度代表
 * 1、选择排序算法(正常人思维首先想到的应该就是选择排序算法)
 * 2、冒牌排序算法
 * 3、插入排序算法
 * <p>
 * <p>
 * nlog(n)算法复杂度代表
 * 4、归并排序算法(分治算法典型代表)
 * 5、快速排序算法(实际工程中最常用和高效的排序算法)
 * 6、堆排序算法(利用小顶堆得堆序性质排序)
 */
public class SortUtils {

    /**
     * 选择排序算法
     *
     * @param data
     */
    public void selectSort(int[] data) {
        if (data.length == 0 || data.length == 1) return;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    swap(data, i, j);
                }
            }
        }
    }





    /**
     * 归并排序算法
     *
     * @param data
     */
    public void mergeSort(int[] data) {

    }

    /**
     * 快速排序算法
     *
     * @param data
     */
    public void quickSort(int[] data) {

    }

    /**
     * 堆排序
     *
     * @param data
     */
    public void heapSort(int[] data) {

    }


    private void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }


    public static void main(String[] args) {

        SortUtils sortUtils = new SortUtils();

        int[] data = new int[]{2, 3, 1, 10, 8, 2, 3, 0};

        sortUtils.selectSort(data);
        System.out.println(Arrays.toString(data));

    }

}
