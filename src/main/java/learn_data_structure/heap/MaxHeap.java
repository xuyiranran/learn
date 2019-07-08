package learn_data_structure.heap;

/**
 * 大顶堆
 * <p>
 * 将其抽象成完全二叉树,利用完全二叉树的性质来解决大顶堆这个问题.
 * <p>
 * left=2*parent+1
 * right=left+1;
 * parent=(left-1)/2
 * <p>
 * 核心概念两点
 * 1、抽象成完全二叉树
 * 2、找出父子节点之间的关系,使用数组存储.
 * 3、插入是新上浮过程,删除顶点是交换后的新顶点的下沉过程.
 */
public class MaxHeap {


    private int[] data;//存储堆的数组
    private int capacity;//堆容量
    private int size;//堆内实际元素个数

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加元素
    // 1、先把元素添加到size索引坐标下
    // 2、然后对size这个索引坐标做上浮操作
    // 3、size++
    public void add(int value) {
        data[size] = value;
        shiftUp(size);
        size++;
    }

    //上浮操作
    private void shiftUp(int index) {
        if (index == 0) return;
        int parent = getParentIndex(index);
        if (data[index] <= data[parent]) return;
        swap(data, parent, index);
        shiftUp(parent);

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
        shiftDown(0);
        return max;

    }

    //下沉操作
    private void shiftDown(int index) {
        if (index >= size - 1) return;
        int left = getLeftIndex(index);
        if (left > size - 1) return;//如果拿出的索引大于等于size的话,那就越界了可以直接返回
        if (left < size - 1) {//如果拿出的索引小于size-1表示左右子节点都存在
            //left和right都存在
            int maxIndex = data[left] > data[left + 1] ? left : left + 1;
            if (data[index] >= data[maxIndex]) return;
            swap(data, maxIndex, index);
            shiftDown(maxIndex);
        } else {//如果拿出的索引等于size-1表示当前只有左节点
            //只存在left
            if (data[index] >= data[left]) return;
            swap(data, left, index);
            shiftDown(left);
        }
    }


    //通过入参传入的数组构造maxHeap
    //1、常规思路就是讲数组中的元素一个的添加到堆中
    //2、我们只需要调整所有非叶子节点顺序,从最后一个非叶子节点开始依次做下沉操作
    public static MaxHeap buildMaxHeap(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array.length);
        maxHeap.data = array;
        maxHeap.size = array.length;
        int lastParentIndex = (array.length - 1) / 2;
        while (lastParentIndex >= 0) {
            maxHeap.shiftDown(lastParentIndex);
            lastParentIndex--;
        }
        return maxHeap;
    }


    //替换顶点元素
    //1、通常的思路就是先删除顶点元素,然后再加入replaceValue元素.时间复杂度为2次logn
    //2、优化方法直接将顶点元素替换为新元素,然后对顶点元素做下沉操作
    public int replace(int replaceValue) {
        if (isEmpty()) throw new IllegalArgumentException("堆为空");
        int max = data[0];
        data[0] = replaceValue;
        shiftDown(0);
        return max;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftIndex(int index) {
        return 2 * index + 1;
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

        maxHeap.replace(1000);
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());


        MaxHeap max=MaxHeap.buildMaxHeap(new int[]{10,100,101,999});

        System.out.println(max.removeMax());

    }


}
