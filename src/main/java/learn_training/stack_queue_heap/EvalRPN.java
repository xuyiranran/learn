package learn_training.stack_queue_heap;


import java.util.Stack;

/**
 * leetcode 150:evaluate reverse polish notation(逆波兰表达式求值)
 *
 *
 * 本题的本质是理解逆波兰表达式的定义。
 *
 * 1.逆波兰表达式求解,定义一个栈辅助计算;
 * 2.当遇到运算符"+"、"-"、"*"、"/"时,从栈中pop出两个数字计算,否则将数字入栈;
 * 3.完结
 *
 */
public class EvalRPN {

    /**
     * 逆波兰表达式实现
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }

}
