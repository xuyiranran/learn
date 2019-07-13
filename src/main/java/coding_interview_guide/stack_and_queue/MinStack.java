package coding_interview_guide.stack_and_queue;

import java.util.Stack;

/**
 * 设计一个有getMin||getMax功能的栈
 *
 *
 * 解题方法
 * 通过使用两个栈来实现,其中一个栈当做普通栈存储数据,另外一个栈只存当前已经入栈元素最小的值.
 * 每次入栈和出栈需要和minStack比较下,minStack是否需要pop.
 *
 */
public class MinStack {


    private Stack<Integer> dataStack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();

    public void push(int value) {
        dataStack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            int curMin = minStack.peek();
            if (value <= curMin) {
                minStack.push(value);
            }
        }

    }

    public int pop() {
        if (dataStack.isEmpty()) throw new IllegalArgumentException("空栈");
        int ret = dataStack.pop();
        int curMin = minStack.peek();
        if (ret <= curMin) {
            minStack.pop();
        }
        return ret;
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new IllegalArgumentException("空栈");
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack minStack=new MinStack();
        minStack.push(10);
        minStack.push(6);
        minStack.push(7);
        minStack.push(3);
        minStack.push(6);
        minStack.push(5);

        System.out.println(minStack.pop());//5
        System.out.println(minStack.getMin());//3
        System.out.println(minStack.pop());//6
        System.out.println(minStack.getMin());//3
        System.out.println(minStack.pop());//3
        System.out.println(minStack.getMin());//3
        System.out.println(minStack.pop());//7
        System.out.println(minStack.getMin());//6


    }

}
