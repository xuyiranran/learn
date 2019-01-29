package learnData.array;

public class ArrayQueue<E> implements Queue<E>{

    private DynamicArray<E> dynamicArray;

    //构造方法
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
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());
        System.out.println(queue);

        int data=queue.dequeue();
        System.out.println(data);

        System.out.println(queue);

    }

}
