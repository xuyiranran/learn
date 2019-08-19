package learn_training.array;

import java.util.Arrays;

/**
 * 合并两个有序数组(同类型问题还有并两个有序链表)
 * <p>
 * 利用两个指针移动来处理
 */
public class MergeSortArray {


    public void mergeSortArray(int[] data1, int[] data2, int[] data) {

        int size1 = data1.length, size2 = data2.length;
        int i = 0, j = 0, count = 0;
        while (i < size1 && j < size2) {
            if (data1[i] <= data2[j]) {
                data[count] = data1[i];
                i++;
            } else {
                data[count] = data2[j];
                j++;
            }
            count++;
        }
        if (i >= size1) {
            for (int k = j; k < size2; k++) {
                data[count] = data2[k];
                count++;
            }
        } else {
            for (int k = i; k < size1; k++) {
                data[count] = data1[k];
                count++;
            }
        }
    }


    public static void main(String[] args) {

        MergeSortArray mergeSortArray = new MergeSortArray();
        int[] data1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] data2 = new int[]{0, 2, 4, 8, 10};
        int[] data = new int[data1.length + data2.length];
        mergeSortArray.mergeSortArray(data1, data2, data);

        System.out.println(Arrays.toString(data));

    }

}
