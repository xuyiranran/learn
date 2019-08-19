package learn_training.array;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * leetcode 75
 * sort color给定一个有n个元素的数组,数组中元素只有0,1,2三种可能,为这个数组排序
 * <p>
 * 其实本质就是基数排序
 * 1、传统解法可以是快速排序算法
 * 2、基于题干给的数组元素只有三种可能,因此应该考虑到基数排序算法。
 * <p>
 * <p>
 * <p>
 * 算法的本质其实就是选择
 * 1、空间换时间
 * 2、时间换空间
 */
public class SortColor {


    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * <p>
     * <p>
     * 目前我这么实现代码是有点繁琐的,如果数组元素种类不止三个,而是更多。
     * 这么写代码没有复用率。应该使用Map数据结构来抽象
     *
     * @param data
     */
    public void sortColor(int[] data) {

        List<Integer> zeroList = Lists.newArrayList();
        List<Integer> oneList = Lists.newArrayList();
        List<Integer> twoList = Lists.newArrayList();
        for (int i = 0; i < data.length; i++) {
            int tmp = data[i];
            if (0 == tmp) {
                zeroList.add(0);
            }
            if (1 == tmp) {
                oneList.add(1);
            }
            if (2 == tmp) {
                twoList.add(2);
            }
        }
        for (int i = 0; i < zeroList.size(); i++) {
            data[i] = 0;
        }
        for (int i = 0; i < oneList.size(); i++) {
            data[zeroList.size() + i] = 1;
        }
        for (int i = 0; i < twoList.size(); i++) {
            data[zeroList.size() + oneList.size() + i] = 2;
        }
    }


    /**
     * 解决上面算法的问题
     *
     * @param data
     * @param elements
     */
    public void sortColor(int[] data, int[] elements) {
        Map<Integer, Integer> countMap = Maps.newTreeMap();
        for (int i = 0; i < elements.length; i++) {
            countMap.put(elements[i], 0);
        }
        for (int i = 0; i < data.length; i++) {
            int element = data[i];
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            int tmp = elements[i];
            for (int j = 0; j < countMap.getOrDefault(tmp, 0); j++) {
                data[count] = tmp;
                count++;
            }
        }
        System.out.println(countMap);
    }


    public static void main(String[] args) {

        SortColor sortColor = new SortColor();
        int[] data = new int[]{0, 1, 2, 1, 2, 1, 1, 1, 2, 0, 0, 0, 0};
        System.out.println(Arrays.toString(data));
        sortColor.sortColor(data, new int[]{0, 1, 2});
        System.out.println(Arrays.toString(data));

    }

}
