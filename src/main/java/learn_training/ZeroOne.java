package learn_training;

/**
 * 0-1背包问题(回溯算法)
 */
public class ZeroOne {


    public int max = Integer.MIN_VALUE;

    /**
     * @param data          物品数组
     * @param capacity      背包容量
     * @param currentIndex  考察当前元素
     * @param currentWeight 背包当前容量
     * @param count         物品个数
     */
    public void fun(int[] data, int capacity, int currentIndex, int currentWeight, int count) {

        if (currentWeight == capacity || currentIndex == count) {
            //背包已满、元素已经考察完了
            if (currentWeight > max) {
                max = currentWeight;
            }
            return;
        }



    }


}
