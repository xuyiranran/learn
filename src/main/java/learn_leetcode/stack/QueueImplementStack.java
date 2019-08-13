package learn_leetcode.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplementStack {


    static class MyStack {

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> tmp = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (queue.isEmpty()) {
                queue.add(x);
            } else {
                while (!queue.isEmpty()) {
                    tmp.add(queue.remove());
                }
                queue.add(x);
                while (!tmp.isEmpty()) {
                    queue.add(tmp.remove());
                }
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {

            if (queue.isEmpty()) return 0;
            return queue.remove();

        }

        /**
         * Get the top element.
         */
        public int top() {
            if (queue.isEmpty()) return 0;
            return queue.peek();

        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }


        static class MyStackV2 {

            Queue<Integer> queue = new ArrayDeque<>();

            public MyStackV2() {

            }

            public void push(int x) {
                int size = queue.size();
                queue.add(x);
                for (int i = 0; i < size; i++) {
                    queue.add(queue.remove());
                }
            }

            public int pop() {
                return queue.remove();
            }

            public int top() {
                return queue.peek();
            }

            public boolean empty() {
                return queue.isEmpty();
            }


        }

        public static void main(String[] args) {


        }

    }

}