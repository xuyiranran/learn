package learn_leetcode;

import java.util.Arrays;

/**
 * 任务调度系统
 */
public class TaskSchule {


    static class Solution {
        public int leastInterval(char[] tasks, int n) {

            if (n == 0 || tasks.length == 1) return tasks.length;
            int[] counts = new int[26];
            for (char c : tasks) {
                counts[c - 'A']++;
            }
            Arrays.sort(counts);

            int maxCount = 0;
            for (int i = 0; i < 25; i++) {
                if (counts[i] == counts[25]) maxCount++;
            }
            return Math.max((counts[25] - 1) * (n + 1) + maxCount, tasks.length);

        }
    }

    public static void main(String[] args) {


        Solution solution=new Solution();
        int count=solution.leastInterval(new char[]{'A','A','A','B','B','B'},2);
        System.out.println(count);
    }
}
