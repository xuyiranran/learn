package chengxuyuanmianshizhinan.stack;


/**
 * 最小栈实现
 * <p>
 * 1、入栈、出栈算法复杂度都是O(1)
 * 2、查询栈中最小元素复杂度也为O(1)
 * 使用两个栈实现,其中一个栈作为普通栈来存储元素,另一个栈存放最小元素列表.
 */
public class MinStack {

    //普通栈
    private Stack simpleStack;
    //最小元素维护栈
    private Stack minStack;

    public MinStack(int capacity) {
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

        MinStack minStack = new MinStack(10);

        minStack.push(1);
        minStack.push(10);
        minStack.push(3);


        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }

}
