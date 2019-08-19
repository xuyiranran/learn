package offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *
 * 思路比较清晰,在出栈操作的时候,如果stack2有数据就先出栈数据,如果没有数据需要把stack1的数据全部装入stack2,才能维护队列的性质。不能部分装入。
 *
 */
public class Solution5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

        Solution5 solution5=new Solution5();

        solution5.push(1);
        solution5.push(2);
        solution5.push(3);
        solution5.push(4);

        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());

    }

}
