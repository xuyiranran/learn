package chengxuyuanmianshizhinan.stack;

/**
 * 反转栈数据元素
 * 1、使用递归(相对复杂)
 * 2、直接再使用一个栈来实现(简单)
 */
public class ReverseStack {

    private Stack stack;

    public ReverseStack() {
        this.stack = new Stack(10);
    }


    private int getAndRemovelast(Stack stack) {

        if (stack.isEmpty()) throw new IllegalArgumentException("空栈数据");
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemovelast(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack stack) {

        if (stack.isEmpty()) return;
        int i = getAndRemovelast(stack);
        reverse(stack);
        stack.push(i);

    }

    public static void main(String[] args) {

        ReverseStack reverseStack = new ReverseStack();
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverseStack.reverse(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
