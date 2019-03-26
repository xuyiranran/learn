package chengxuyuanmianshizhinan.stack.first_stack_and_queue;


/**
 * 最小栈实现
 * <p>
 * 1、入栈、出栈算法复杂度都是O(1)
 * 2、查询栈中最小元素复杂度也为O(1)
 * 使用两个栈实现,其中一个栈作为普通栈来存储元素,另一个栈存放最小元素列表.
 */
public class StackWithGetMin {

    //普通栈
    private Stack simpleStack;
    //最小元素维护栈
    private Stack minStack;

    public StackWithGetMin(int capacity) {
        simpleStack = new Stack(capacity);
        minStack = new Stack(capacity);
    }

    public void push(int data) {

        if (simpleStack.isEmpty()) {
            simpleStack.push(data);
            minStack.push(data);
            return;
        }
        simpleStack.push(data);
        int min = minStack.peek();
        if (data >= min) {
            minStack.push(min);
        } else {
            minStack.push(data);
        }
    }

    public int pop() {
        int result = simpleStack.pop();
        minStack.pop();
        return result;
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {

        StackWithGetMin stackWithGetMin = new StackWithGetMin(10);

        stackWithGetMin.push(1);
        stackWithGetMin.push(10);
        stackWithGetMin.push(3);


        System.out.println(stackWithGetMin.getMin());
        stackWithGetMin.pop();
        System.out.println(stackWithGetMin.getMin());


    }

}
