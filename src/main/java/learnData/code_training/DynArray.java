package learnData.code_training;

/**
 * 构建动态数组的重点
 * 1、每次添加元素的时候需要考虑元素个数size是否等于数组长度(有时即将达到数组长度也要扩容),如果是那么申请一个更大的静态数组来存储元素(将原来的数组元素拷贝过阿里).
 * 2、每次删除元素的时候需要考虑元素size是否比数组长度一半还小(这个阈值可调整),如果小于某个范围那么可以考虑缩容来解决内存.
 * 3、如果删除和插入不是发生在数组最后一个下标,那么需要考虑移动数组后边的元素以保持元素连续性.
 */
public class DynArray {

    //存放数据的数组
    private int[] data;
    //元素个数
    private int size;

    //默认初始化数组大小
    private static final int DEFAULT_CAPACITY = 10;

    public DynArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynArray(int capacity) {
        data = new int[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 添加元素(添加到数组最后面)
     * 1、需要考虑静态数组容量是否足够添加
     * 2、如果静态数组容量不足则扩容
     *
     * @param element
     */
    public void addLast(int element) {
        if (size >= data.length - 1) resize(data.length * 2);
        data[size] = element;
        size++;
    }

    /**
     *
     */
    public void addIndex(int index, int element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("数组越界");
        if (size >= data.length - 1) resize(data.length * 2);
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    /**
     * 删除数组最后一个元素
     *
     * @return
     */
    public int deleteLast() {
        if (size == 0) throw new RuntimeException("空集合");
        if (size + 1 < data.length / 2) resize(data.length / 2);
        int removeData = data[size - 1];
        size--;
        return removeData;
    }

    /**
     * @param index
     * @return
     */
    public int deleteIndex(int index) {
        if (size == 0) throw new RuntimeException("空集合");
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("数组越界");
        //暂存待删除元素
        int removeData = data[index];
        //将index+1到size位置元素往前移动一位
        for (int i = index; i < size; i++) {
            data[index] = data[index + 1];
        }
        size--;
        return removeData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i] + "->");
        }
        return sb.toString();
    }

    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    public static void main(String[] args) {

        DynArray dynArray = new DynArray(4);
        dynArray.addLast(1);
        dynArray.addLast(1);
        dynArray.addLast(1);
        dynArray.addLast(1);
        dynArray.addIndex(1, 99);

        System.out.println(dynArray.toString());

        dynArray.deleteIndex(1);
        dynArray.deleteIndex(2);
        dynArray.deleteIndex(0);

        System.out.println(dynArray.toString());

    }


}
