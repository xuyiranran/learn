package coding_interview_guide.stack_and_queue;

import java.util.Stack;

/**
 * 使用递归函数和栈操作逆序一个栈
 * <p>
 * 这个设计题仅仅是为了提高算法练习能力,练习递归函数和递归思想。
 * 如果真要逆序一个栈只需要借助另外一个栈或队列即可实现.
 */
public class RecursiveReverseStack {


    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int i = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(i);
    }

    private int getAndRemoveLastElement(Stack<Integer> stack) {
        if (stack.isEmpty()) throw new IllegalArgumentException("空栈");
        int pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(pop);
            return last;
        }
    }

    public static void main(String[] args) {

        RecursiveReverseStack stack = new RecursiveReverseStack();
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        stack.reverseStack(stack1);

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());

    }

}
