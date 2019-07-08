package learn_data_structure.heap;

/**
 * 大顶堆
 * <p>
 * 将其抽象成完全二叉树,利用完全二叉树的性质来解决大顶堆这个问题.
 * <p>
 * left=2*parent+1
 * right=left+1;
 * parent=(left-1)/2
 *
 * 核心概念两点
 * 1、抽象成完全二叉树
 * 2、找出父子节点之间的关系,使用数组存储.
 * 3、插入是新上浮过程,删除顶点是交换后的新顶点的下沉过程.
 */
public class MaxHeap {


    private int[] data;
    private int capacity;
    private int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加元素1、先把元素添加到size-1索引坐标下 2、然后对size-1这个索引坐标做上浮操作
    public void add(int value) {

        if (isEmpty()) {
            data[0] = value;
            size++;
            return;
        } else {
            data[size] = value;
            //上浮操作
            shiftUp(size, value);
            size++;
        }
    }

    //上浮操作
    private void shiftUp(int index, int value) {
        if (index == 0) return;
        int parent = getParentIndex(index);
        if (value > data[parent]) {
            swap(data, parent, index);
            shiftUp(parent, value);
        }
    }

    public int peekMax() {
        if (isEmpty()) throw new IllegalArgumentException("空堆");
        return data[0];
    }

    /**
     * 删除顶点元素(即最大元素)
     * 1、先交换顶点元素和最后一个元素
     * 2、然后对新的顶点元素做下沉操作
     *
     * @return
     */
    public int removeMax() {
        if (isEmpty()) throw new IllegalArgumentException("空堆");
        int max = data[0];
        swap(data, 0, size - 1);
        size--;
        shiftDown(0, data[0]);
        return max;

    }

    //下沉操作
    private void shiftDown(int index, int value) {
        int left = getLeftIndex(index);
        if (left >= size) return;//如果拿出的索引大于等于size的话,那就越界了可以直接返回
        if (left < size - 1) {//如果拿出的索引小于size-1表示左右子节点都存在
            //left和right都存在
            int maxIndex = data[left] > data[left + 1] ? left : left + 1;
            if (value >= data[maxIndex]) return;
            swap(data, maxIndex, index);
            shiftDown(maxIndex, value);
        } else if (left == size - 1) {//如果拿出的索引等于size-1表示当前只有左节点
            //只存在left
            if (value >= data[left]) return;
            swap(data, left, index);
            shiftDown(left, value);
        }

    }

    private void swap(int[] array, int first, int second) {
        int tmp = data[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(7);
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(4);

        System.out.println(maxHeap.peekMax());

        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());

    }


}
