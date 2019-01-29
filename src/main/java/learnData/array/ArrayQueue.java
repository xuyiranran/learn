package learnData.array;

/**
 * 基于普通数组实现队列接口
 * addLast&getFirst
 * 复杂度分析
 * 入队操作由于是从数组末尾直接插入元素复杂度为O(1)
 * 出队操作由于是删除数组第一个元素,需要将后面的元素往前移动一位。时间复杂度为O(n)
 * 结论:基于普通数组实现队列,出队性能较差.
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E>{

    private DynamicArray<E> dynamicArray;

    public ArrayQueue(int capacity){
        dynamicArray= new DynamicArray<>(capacity);
    }

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(E e) {
        dynamicArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return dynamicArray.removeFirst();
    }

    @Override
    public E peek() {
        return dynamicArray.getFirst();
    }

    @Override
    public int size() {
        return dynamicArray.size();
    }

    @Override
    public boolean isEmpty() {
        return dynamicArray.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<size();i++){
            sb.append(dynamicArray.get(i)+"<-");
        }
        sb.append("size:"+size());
        return sb.toString();
    }

    public static void main(String[] args) {

//        Queue<Integer> queue=new ArrayQueue<>(10);

        Queue<Integer> queue=new LoopQueue<>(10);

        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());
        System.out.println(queue);

        int data=queue.dequeue();
        data=queue.dequeue();
        System.out.println(data);

        System.out.println(queue);

    }

}
