package learnData.linklist;

import learnData.array.Stack;

/**
 * 基于链表实现Stack接口
 * Stack
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList=new LinkedList<>();

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int size() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        return linkedList.toString();
    }

    public static void main(String[] args) {

        Stack<Integer> stack=new LinkedListStack();
        for (int i = 0; i <10 ; i++) {
            stack.push(i);
        }
        System.out.println(stack.toString());

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.toString());

    }

}
