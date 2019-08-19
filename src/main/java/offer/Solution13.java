package offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 *
 * 使用两个栈来存储,其中一个栈存储正常元素,另外一个栈存储最小值
 *
 */
public class Solution13 {


    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public Solution13() {
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
}
