package chengxuyuanmianshizhinan.stack.first_stack_and_queue;

/**
 * 利用一个额外的栈,将栈里面的元素排序
 * <p>
 * 算法核心思想
 * stack弹出的元素和辅助栈stack的栈顶元素比较,如果比辅助栈顶元素小则将辅助栈顶元素弹出压入原始栈,直到辅助栈顶元素小于该元素或辅助栈为空
 */
public class StackSort {

    private Stack helpStack;

    public StackSort() {
        helpStack = new Stack();
    }

    public void sort(Stack stack) {
        if (stack.isEmpty()) return;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (helpStack.isEmpty()) {
                helpStack.push(cur);
            } else {
                if (cur < helpStack.peek()) {
                    while (!helpStack.isEmpty() && cur < helpStack.peek()) {
                        stack.push(helpStack.pop());
                    }
                }
                helpStack.push(cur);
            }
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }


    public static void main(String[] args) {

        StackSort stackSort = new StackSort();
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stackSort.sort(stack);
        System.out.println(stack.toString());


    }


}
