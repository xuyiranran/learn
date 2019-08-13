package coding_interview_guide.stack_and_queue;

import java.util.Stack;

/**
 * 设计一个队列,由两个栈实现队列功能
 * <p>
 * 实现的核心一点在于,当出队peek时,如果stack2为空的话,需要把stack1所有的元素都移动到stack2上。
 */
public class TwoStackBeQueue {


    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int value) {
        stack1.push(value);
    }


    public int dequeue() {
        if (stack2.isEmpty() && stack1.isEmpty()) throw new IllegalArgumentException("空队列");
        //如果stack2为空需要把stack1所有的元素都弹出压入到stack2中,只有stack2为空才能做这个操作
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public int peek() {
        if (stack2.isEmpty() && stack1.isEmpty()) throw new IllegalArgumentException("空队列");
        //如果stack2为空需要把stack1所有的元素都弹出压入到stack2中,只有stack2为空才能做这个操作
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }


    public static void main(String[] args) {

        TwoStackBeQueue queue = new TwoStackBeQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());

        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());


    }


}
