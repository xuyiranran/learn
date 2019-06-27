package learn_leetcode;

import java.util.Stack;

/**
 * 实现最小栈
 * <p>
 * 通过两个普通栈实现最小栈功能。
 * <p>
 * 最小栈和最大栈是一个原理
 */
class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            int peek = min.peek();
            if (peek >= x) {
                min.push(x);
            }
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (!min.isEmpty()) {
            if (pop <= min.peek()) {
                min.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (min.isEmpty()) return 0;
        return min.peek();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(5);
        minStack.push(2);
        minStack.push(0);
        minStack.push(-10);

        System.out.println(minStack.getMin());

    }
}
