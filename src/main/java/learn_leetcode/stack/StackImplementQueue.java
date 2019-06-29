package learn_leetcode.stack;

import java.util.Stack;

public class StackImplementQueue {


    static class MyQueue {

        private Stack<Integer> stack=new Stack<>();
        private Stack<Integer> tmp=new Stack<>();


        /** Initialize your data structure here. */
        public MyQueue() {

        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(x);
            }else {
                while (!stack.isEmpty()){
                    tmp.push(stack.pop());
                }
                stack.push(x);
                while (!tmp.isEmpty()){
                    stack.push(tmp.pop());
                }
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }


    public static void main(String[] args) {

        MyQueue queue=new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println(queue.peek());

        System.out.println(queue.empty());

    }
}
