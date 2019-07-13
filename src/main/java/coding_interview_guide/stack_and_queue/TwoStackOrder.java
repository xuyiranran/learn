package coding_interview_guide.stack_and_queue;

import java.util.Stack;

/**
 * 使用一个栈实现另一个栈的排序(从小到大||从大到小)
 * <p>
 * 核心思想:辅助栈存放顺序的元素,如果stack弹出的元素比辅助栈顶元素还小,那么辅助栈将栈内元素全部压入原始栈中.
 */
public class TwoStackOrder {

    public void orderStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (help.isEmpty()) {
                help.push(pop);
            } else {
                int peek = help.peek();
                if (pop > peek) {
                    while (!help.isEmpty()) {
                        stack.push(help.pop());
                    }
                    help.push(pop);
                } else {
                    help.push(pop);
                }
            }

            //上面的代码可以精简成下面几行代码
//            while (!help.isEmpty()&&pop>help.peek()){
//                stack.push(help.pop());
//            }
//            help.push(pop);

        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }


    public static void main(String[] args) {

        TwoStackOrder twoStackOrder = new TwoStackOrder();

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(5);
        stack.push(8);
        stack.push(9);
        stack.push(1);
        twoStackOrder.orderStack(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
