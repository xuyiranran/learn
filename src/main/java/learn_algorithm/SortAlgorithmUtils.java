package learn_algorithm;

import learn_data_structure.heap.MinHeap;

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
public class SortAlgorithmUtils {

    /**
     * 选择排序算法
     * <p>
     * 选择排序算法的核心思想
     * 1、每一次循环选择出最小值,赋值在i上(i从0->n-1)
     * 2、使用的双重for循环,外层为0到n-1(最后一个元素无需比较),内层为1到n。
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
     * 冒泡排序算法
     * 冒泡排序核心思想
     * 1、每一次循环选择出最大值,赋值给n-i(从n-1到1)
     * 2、每次比较都是临近的元素比较
     * <p>
     * 冒泡排序和选择的排序的顺序有点相反.
     *
     * @param data
     */
    public void maopaoSort(int[] data) {
        if (data.length <= 1) return;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序算法
     *
     * @param data
     */
    public void insertSort(int[] data) {

    }


    //归并排序的辅助数组
    public int[] help;

    /**
     * 归并排序算法
     * 1、先拆分(分治算法)
     * 2、再合并子问题
     *
     * @param data
     */
    public void mergeSort(int[] data) {
        if (data.length <= 1) return;
        help = new int[data.length];
        divideSort(data, 0, data.length - 1);
    }

    /**
     * 归并排序第一步:拆分出子问题,分治。
     *
     * @param data
     * @param left
     * @param right
     */
    private void divideSort(int[] data, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        divideSort(data, left, middle);
        divideSort(data, middle + 1, right);
        merge(data, left, middle, right);

    }

    /**
     * 归并排序第二步:归并排序的难点在于merge操作
     * <p>
     * 将两段数组[left...middle]和[middle...right]合并,它们各自都是有序的.
     *
     * @param data
     * @param left
     * @param middle
     * @param right
     */
    private void merge(int[] data, int left, int middle, int right) {
        //合并[left,middle]和[middle+1,right],左右两个子数组都是有序的.
        int leftStart = left, rightStart = middle + 1;
        for (int i = left; i <= right; i++) {
            help[i] = data[i];
        }
        for (int i = left; i <= right; i++) {
            if (leftStart > middle) {//左边子数组用光了
                data[i] = help[rightStart++];
            } else if (rightStart > right) {//右边子数组用光了
                data[i] = help[leftStart++];
            } else if (help[leftStart] < help[rightStart]) {//左边子数组下一个元素小于右边子数组下一个元素
                data[i] = help[leftStart++];
            } else {//左边子数组下一个元素小于右边子数组下一个元素
                data[i] = help[rightStart++];
            }
        }
    }


    /**
     * 快速排序算法
     *
     * @param data
     */
    public void quickSort(int[] data) {
        if (data.length <= 1) return;
        qSort(data, 0, data.length - 1);

    }

    /**
     * 递归排序函数
     * @param data
     * @param left
     * @param right
     */
    private void qSort(int[] data, int left, int right) {
        if (left >= right) return;
        int index = partIndex(data, left, right);
        System.out.println("index:"+index);
        qSort(data, left, index - 1);
        qSort(data, index + 1, right);
    }


    /**
     * 获取基数下标
     * @param data
     * @param left
     * @param right
     * @return
     */
    private int partIndex(int[] data, int left, int right) {
        int leftIndex = left, rightIndex = right;
        int value = data[leftIndex];
        while (true) {
            if (leftIndex >= rightIndex) break;
            while (leftIndex < rightIndex && data[rightIndex] >= value) {//向左扫描一直扫到第一个小于目标值的下标
                rightIndex--;
            }
            while (leftIndex < rightIndex && data[leftIndex] <= value) {//向右扫描一直到扫到一个大于目标值的下标
                leftIndex++;
            }
            swap(data, leftIndex, rightIndex);
        }
        swap(data, left, leftIndex);
        return leftIndex;
    }

    /**
     * 堆排序
     *
     * @param data
     */
    public void heapSort(int[] data) {
//        MinHeap minHeap = MinHeap.buildMinHeap(Arrays.copyOf(data, data.length));
//        int size = minHeap.getSize();
//        for (int i = 0; i < size; i++) {
//            data[i] = minHeap.remove();
//        }

        MinHeap minHeap = new MinHeap(data.length);
        for (int i = 0; i < data.length; i++) {
            minHeap.add(data[i]);
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = minHeap.remove();
        }

    }

    private void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }


    public static void main(String[] args) {

        SortAlgorithmUtils sortUtils = new SortAlgorithmUtils();

        int[] data = new int[]{2, 1, 10, 6, 5, 7, 0};
        System.out.println(Arrays.toString(data));

//        sortUtils.selectSort(data);
//        sortUtils.maopaoSort(data);
//        sortUtils.mergeSort(data);
        sortUtils.quickSort(data);
//        sortUtils.heapSort(data);
        System.out.println(Arrays.toString(data));


    }

}
