package learn_leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 基于队列实现最近的请求次数(3秒内的请求次数)
 */
public class RecentCounterFunction {

    static class RecentCounter {

        private Queue<Integer> queue = new ArrayDeque<>();

        public RecentCounter() {

        }

        public int ping(int t) {

            if (queue.isEmpty()) {
                queue.add(t);
            } else {
                int peek = queue.peek();
                while (t - peek > 3000) {
                    queue.remove();
                    if (queue.isEmpty()) break;
                    peek = queue.peek();
                }
                queue.add(t);
            }
            return queue.size();
        }

        public void input(int[] array) {
            for (int i : array) {
                ping(i);
            }
        }

    }

    public static void main(String[] args) {

        RecentCounter recentCounter = new RecentCounter();
        recentCounter.input(new int[]{1, 100, 4000});

        System.out.println(recentCounter.ping(1));//1
        System.out.println(recentCounter.ping(100));//2
        System.out.println(recentCounter.ping(4000));//2

    }
}
