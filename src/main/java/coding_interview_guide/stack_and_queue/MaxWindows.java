package coding_interview_guide.stack_and_queue;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成最大值数组(最大窗口)
 * <p>
 * {4, 3, 5, 4, 3, 3, 6, 7},最大窗口为3时,结果为[2, 2, 2, 3, 6, 7]下标
 */
public class MaxWindows {


    //一般思维就是两次循环,时间复杂度为O(M*N) M为数组长度、N为最大窗口大小
    public int[] getMaxWindows(int[] array, int maxSize) {
        int[] result = new int[array.length - maxSize + 1];
        for (int i = 0; i <= array.length - maxSize; i++) {
            int maxIndex = i;
            for (int j = i; j < maxSize + i; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            result[i] = maxIndex;
        }
        return result;
    }

    //通过使用双端队列(LinkedList),如果插入的元素小于最后一个元素那么就直接加入到链表最后,如果插入元素大于链表最后一个元素就将链表最后一个元素删除,再和链表最后一个元素比较直到满足条件或链表为空.
    public int[] getMaxWindowsVersion2(int[] array, int maxSize) {
        int[] result = new int[array.length - maxSize + 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < maxSize; i++) {
            while (!linkedList.isEmpty() && array[i] > linkedList.getLast()) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
        }
        result[0] = linkedList.getFirst();
        for (int i = maxSize; i < array.length; i++) {
            while (!linkedList.isEmpty() && array[i] > array[linkedList.getLast()]) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
            if (linkedList.getLast() - linkedList.getFirst() >= maxSize) {
                linkedList.removeFirst();
            }
            result[i + 1 - maxSize] = linkedList.getFirst();
        }
        return result;
    }

    //代码精简版的最大滑动窗口
    public int[] getMaxWindowsVersion3(int[] array, int maxSize) {
        int[] result = new int[array.length - maxSize + 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!linkedList.isEmpty() && array[i] > array[linkedList.getLast()]) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
            if (linkedList.getLast() - linkedList.getFirst() >= maxSize) {
                linkedList.removeFirst();
            }
            if (i >= maxSize - 1) {
                result[i + 1 - maxSize] = linkedList.getFirst();
            }
        }
        return result;
    }

    public static void main(String[] args) {

        MaxWindows maxWindows = new MaxWindows();
        int[] array = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int[] result = maxWindows.getMaxWindows(array, 3);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(maxWindows.getMaxWindowsVersion2(array, 3)));
        System.out.println(Arrays.toString(maxWindows.getMaxWindowsVersion3(array, 3)));

    }

}
