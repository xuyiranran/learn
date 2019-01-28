package learnData.array;

/**
 * 动态数组实现
 *
 * @param <E>
 */
public class DynamicArray<E> {

    //数组元素size
    private int size;

    //数组对象
    private E[] data;

    //数组容量
    private int capacity;

    //默认初始化容量大小
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public DynamicArray() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //增

    /**
     * 算法复杂度O(n)
     * 需要将size-index后面的元素都往后移动一位
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(String.format("不合法的下标index:%s,size:%s", index, size));
        }
        if (size >= capacity - 1) {
            resize(capacity * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 算法复杂度O(1)
     * 直接在数组index=size下标赋值
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 算法复杂度O(n)
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    //删

    /**
     * 算法复杂度O(n)
     * 需要将下标在(index,size]范围元素往前移动一位
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(String.format("不合法的下标index:%s,size:%s", index, size));
        }
        E removeElement = data[index];
        if (size < capacity / 2) {
            resize(capacity / 2);
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removeElement;
    }

    /**
     * 算法复杂度O(n)
     * 将1到size的下标元素都往前移一位
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 算法复杂度O(1)
     *
     * @return
     */
    public E removeLast() {
        return remove(size);
    }

    //改

    /**
     * 算法复杂度O(1)
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(String.format("不合法的下标index:%s,size:%s", index, size));
        }
        data[index] = e;
        size++;
    }

    //查

    /**
     * 算法复杂度O(1)
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException(String.format("不合法的下标index:%s,size:%s", index, size));
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
       return get(0);
    }

    /**
     * 算法复杂度O(n)
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 动态扩容或缩容
     *
     * @param newCapacity
     */
    public void resize(int newCapacity) {
        if (newCapacity < 1) {
            throw new IllegalArgumentException(String.format("不合法的容量大小capactiy:%s", newCapacity));
        }
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]+",");
        }
        sb.append("size:" + size + "capacity:" + capacity);
        return sb.toString();
    }

    public static void main(String[] args) {

        DynamicArray<Integer> dynamicArray = new DynamicArray<>(5);

        for (int i = 0; i < 5; i++) {
            dynamicArray.add(i, i);
        }
        System.out.println(dynamicArray);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);
        dynamicArray.addFirst(-1);
        dynamicArray.add(2,666);
        System.out.println(dynamicArray);

        dynamicArray.removeFirst();
        dynamicArray.removeLast();
        System.out.println(dynamicArray);
    }

}
