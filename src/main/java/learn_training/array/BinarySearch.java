package learn_training.array;

/**
 * 如果准确写出一个bug free的二分搜索算法
 * <p>
 * 循环不变量概念的引入
 *
 *
 * 二分查找算法是解决一些问题的有效基本算法,主要针对的是有序的数组
 * 这里之所以说有序数组,而不是有序数据主要是因为除了有序,还需要支持快速随机访问。比如即使是有序链表,也没办法使用二分搜索算法来快速查找。
 */
public class BinarySearch {


    /**
     * 二分搜索算法,基于循环实现。
     * @param data
     * @param target
     * @return
     */
    public int binarySearchLoop(int[] data, int target) {
        if (data == null || data.length == 0) return -1;
        int begin = 0, end = data.length - 1;//定义循环不变量[begin,end],左闭区间右闭区间。
        while (begin <= end) {
            int middle = begin + (end - begin) / 2;//防止int越界
            int middleValue = data[middle];
            if (target == middleValue) {
                return middle;
            } else if (target > middleValue) {
                begin = middle + 1;//根据前面循环不变量定义来理解
            } else {//target<middleValue
                end = middle - 1;//根据前面循环不变量定义来理解
            }
        }
        return -1;
    }


    /**
     * 二分搜索算法(基于递归实现)
     * @param data
     * @param target
     * @return
     */
    public int binarySerarchRecurive(int[] data, int target) {
        int begin = 0, end = data.length - 1;//循环不变量[begin,end]
        return search(data, target, begin, end);

    }

    private int search(int[] data, int target, int begin, int end) {

        if (begin > end) return -1;//递归退出条件,这里不是begin>=end,因为begin==end也是有效的。
        int middle = begin + (end - begin) / 2;//防止int越界
        int middleValue = data[middle];
        if (target == middleValue) {
            return middle;
        } else if (target > middleValue) {
            return search(data, target, middle + 1, end);
        } else {
            return search(data, target, begin, middle - 1);
        }


    }


    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();

        int size = 1_000_000;
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            int ret = binarySearch.binarySerarchRecurive(data, i);
            assert ret == i;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));


    }


}
