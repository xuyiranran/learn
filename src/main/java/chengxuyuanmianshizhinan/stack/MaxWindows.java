package chengxuyuanmianshizhinan.stack;

import java.util.LinkedList;

/**
 * 生成窗口最大数组
 */
public class MaxWindows {


    //复杂度为O(N*M)
    public int[] maxWindowsWorse(int[] arr, int m) {

        if (arr == null || arr.length == 1) return arr;
        if (arr.length < m) throw new IllegalArgumentException("不合法窗口大小");
        int[] result = new int[arr.length + 1 - m];
        for (int i = 0; i < arr.length + 1 - m; i++) {
            int max = arr[i];
            for (int j = 0; j < m; j++) {
                if (max < arr[i + j]) {
                    max = arr[i + j];
                }
            }
            result[i] = max;
        }
        return result;
    }


    //复杂度为O(N)
    public int[] maxWindowsBetter(int[] arr, int m) {

        if (arr == null || arr.length == 1) return arr;
        if (arr.length < m) throw new IllegalArgumentException("不合法窗口大小");
        int[] result = new int[arr.length + 1 - m];

        LinkedList<Integer> linkedList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            while (!linkedList.isEmpty() && arr[linkedList.peekLast()] < arr[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            //过期下标
            if (linkedList.peekFirst() == i - m) {
                linkedList.pollFirst();
            }
            //从第m次循环开始就可以添加最大元素了.
            if (i >= m - 1) {
                result[index++] = arr[linkedList.peekFirst()];
            }
        }
        return result;
    }


    public static void main(String[] args) {

        MaxWindows maxWindows = new MaxWindows();
        int[] max = maxWindows.maxWindowsWorse(new int[]{1, 2, 3, 8, 5, 6, 7}, 3);

        for (int m : max) {
            System.out.print(m + "-->");
        }

        System.out.println();
        System.out.println("----");
        int[] better = maxWindows.maxWindowsBetter(new int[]{1, 2, 3, 8, 5, 6, 7}, 3);

        for (int m : better) {
            System.out.print(m + "-->");
        }


    }

}
