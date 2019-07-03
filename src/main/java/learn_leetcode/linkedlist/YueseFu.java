package learn_leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class YueseFu {


    private static int leftNum(int[] nums, int flag) {

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int count = 0;
        while (queue.size() != 1) {
            count++;
            int remove = queue.remove();
            if (count != flag) {
                queue.add(remove);
            } else {
                count = 0;
            }
        }
        return queue.remove();

    }


    public static void main(String[] args) {

        System.out.println(leftNum(new int[]{1, 2, 3}, 2));
        System.out.println(leftNum(new int[]{1, 2, 3, 4}, 3));

    }

}
