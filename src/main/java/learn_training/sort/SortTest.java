package learn_training.sort;

import java.util.Arrays;

public class SortTest {

    /**
     * 选择排序的特点
     * 每一次循环取出最小的数据放在当前i位置
     *
     * @param data
     */
    public void selectSort(int[] data) {
        if (data == null) return;
        if (data.length == 1) return;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length - 1; j++) {
                if (data[i] > data[j]) {
                    swap(data, i, j);
                }
            }
        }
    }


    private int[] help;

    /**
     * 归并排序核心思想先分治后合并
     *
     * @param data
     */
    public void mergeSort(int[] data) {
        help = new int[data.length];
        divide(data, 0, data.length - 1);
    }


    private void divide(int[] data, int start, int end) {

        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        divide(data, start, middle);
        divide(data, middle + 1, end);
        merge(data, start, middle, end);
    }

    private void merge(int[] data, int left, int middle, int right) {

        int leftIndex = left, rightIndex = middle + 1;
        //合并
        for (int i = leftIndex; i <= right; i++) {
            help[i] = data[i];
        }
        for (int i = leftIndex; i <= right; i++) {
            if (leftIndex > middle) {//左边数组已经取完
                data[i] = help[rightIndex++];
            } else if (rightIndex > right) {
                data[i]=help[leftIndex++];
            }else if (help[leftIndex]>help[rightIndex]){
                data[i]=help[rightIndex++];
            }else {
                data[i]=help[leftIndex++];
            }
        }
    }


    public void quickSort(int[] data) {
        qSort(data, 0, data.length - 1);
    }

    private void qSort(int[] data, int left, int right) {

        if (left >= right) return;
        int partion = partion(data, left, right);
        qSort(data, left, partion);
        qSort(data, partion + 1, right);


    }

    private int partion(int[] data, int left, int right) {

        int leftIndex = left, rightIndex = right;
        int value = data[left];
        while (true) {
            if (leftIndex >= rightIndex) break;
            while (leftIndex < rightIndex && data[rightIndex] > value) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && data[leftIndex] < value) {
                leftIndex++;
            }
            swap(data, leftIndex, rightIndex);
        }
        return leftIndex;
    }


    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    public static void main(String[] args) {

        SortTest sortTest = new SortTest();

        int[] data = new int[]{1, 6, 3, 2, 0, 10, 7, 8, 5};
        System.out.println(Arrays.toString(data));
//        sortTest.selectSort(data);
//        sortTest.quickSort(data);
        sortTest.mergeSort(data);
        System.out.println(Arrays.toString(data));

    }

}
