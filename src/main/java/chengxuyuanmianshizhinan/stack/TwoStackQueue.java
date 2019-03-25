package chengxuyuanmianshizhinan.stack;

/**
 * 利用两个栈实现队列功能
 * 1、由于栈是后进先出所以使用两个栈一个作为入栈一个作为出栈则可以满足先进先出要求
 * 2、在dequeue或peek操作时,需要保证如果出栈队列为空那么要把所有的入栈队列数据都弹出到出栈队列上.
 *
 *
 * 说明:实际场景不会这么来实现队列功能,仅做练习.
 */
public class TwoStackQueue {


    private int capacity;

    //入栈队列栈
    private Stack enqueueStack;
    //出栈队列栈
    private Stack dequeueStack;

    public TwoStackQueue(int capacity) {
        this.capacity = capacity;
        enqueueStack = new Stack(capacity);
        dequeueStack = new Stack(capacity);
    }

    //入栈不需要任何考虑
    public void enqueue(int data) {
        enqueueStack.push(data);
    }

    //出栈队列弹出元素时(如果出栈队列为空,则将所有的入栈队列数据移入出栈队列中)
    public int dequeue() {
        if (dequeueStack.isEmpty() && enqueueStack.isEmpty()) throw new IllegalArgumentException("空栈");
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    //出栈队列查看元素时(如果出栈队列为空,则将所有的入栈队列数据移入出栈队列中)
    public int peek() {
        if (dequeueStack.isEmpty()) throw new IllegalArgumentException("空栈");
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }


    public static void main(String[] args) {

        TwoStackQueue queue = new TwoStackQueue(10);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        }

    }

}
