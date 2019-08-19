package learn_training.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 移动数组中所有O元素到数组末尾
 */
public class MoveZeroElements {


    /**
     * 移动所有0元素到数组最后
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param data
     */
    public void moveZeroElementsV1(int[] data) {

        Queue<Integer> noZeroElements = new ArrayDeque<>();
        for (int i = 0; i < data.length; i++) {
            int element = data[i];
            if (element != 0) {
                noZeroElements.add(element);
            }
        }

        for (int i = 0; i < data.length; i++) {
            if (!noZeroElements.isEmpty()) {
                data[i] = noZeroElements.remove();
            } else {
                data[i] = 0;
            }
        }
    }

    /**
     * 使用头尾碰撞指针
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * <p>
     * 但是这有个问题,非0元素的相对顺序是会发生变化的,主要看题目有没有要求这点,如果没有要求就可以这么写。
     *
     * @param data
     */
    public void moveZeroElementsV2(int[] data) {

        int i = 0, j = data.length - 1;//循环不变量[i,j],i==j的时候交换位置是没有意义的
        while (i < j) {
            while (i < j && data[i] != 0) {
                i++;
            }
            while (i < j && data[j] == 0) {
                j--;
            }
            swap(data, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    public static void main(String[] args) {

        MoveZeroElements moveZeroElements = new MoveZeroElements();

        int[] data = new int[]{1, 0, 0, 2, 0, 4, 5, 0};

        System.out.println(Arrays.toString(data));

//        moveZeroElements.moveZeroElementsV1(data);
        moveZeroElements.moveZeroElementsV2(data);

        System.out.println(Arrays.toString(data));


    }


}
