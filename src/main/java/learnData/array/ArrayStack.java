package learnData.array;

/**
 * 基于数组实现栈接口
 * @param <E>
 */
public class ArrayStack<E extends Comparable<E>> implements Stack<E>{

    //数组
    private DynamicArray<E> dynamicArray;

    //构造方法
    public ArrayStack(int capacity){
        dynamicArray= new DynamicArray<>(capacity);
    }

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void push(E e) {
        dynamicArray.addLast(e);
    }

    @Override
    public E pop() {
        return dynamicArray.removeLast();
    }

    @Override
    public E peek() {
        return dynamicArray.getLast();
    }

    @Override
    public int size() {
        return dynamicArray.size();
    }

    @Override
    public boolean isEmpty() {
        return dynamicArray.isEmpty();
    }
}
