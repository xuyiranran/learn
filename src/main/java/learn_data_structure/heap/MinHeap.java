package learn_data_structure.heap;

/**
 * 小顶堆
 * <p>
 * 基于二叉树实现小顶对
 */
public class MinHeap {

    private int[] data;//实际存储堆元素的数组
    private int capacity;//数组初始化大小
    private int size;//数组实际元素个数

    public MinHeap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //查看堆顶元素
    public int peek() {
        if (isEmpty()) throw new IllegalArgumentException("堆为空");
        return data[0];
    }

    //添加元素
    public void add(int value) {
        data[size] = value;
        shiftUp(size);
        size++;
    }

    /**
     * 上浮操作直到不能继续上浮位置(比父亲节点大或上浮到顶点即index=0)
     *
     * @param index
     */
    private void shiftUp(int index) {
        if (index == 0) return;
        int parentIndex = parentIndex(index);
        if (data[index] >= data[parentIndex]) return;
        swap(data, index, parentIndex);
        shiftUp(parentIndex);
    }

    //删除顶点元素
    // 1、交换顶点和最后元素的值
    // 2、从顶点开始一直下沉操作直到不能继续下沉(比孩子节点最小的节点还小或到达index=size-1)
    public int remove() {
        if (isEmpty()) throw new IllegalArgumentException("堆为空");
        int min = data[0];
        swap(data, 0, size - 1);
        size--;
        shiftDown(0);
        return min;
    }

    //下沉操作
    private void shiftDown(int index) {
        if (index >= size - 1) return;
        int left = leftIndex(index);
        if (left > size - 1) return;
        if (left < size - 1) {
            //左右节点都存在
            int minIndex = data[left] < data[left + 1] ? left : left + 1;
            if (data[index] <= data[minIndex]) return;
            swap(data, index, minIndex);
            shiftDown(minIndex);
        } else {
            //只存在左节点
            if (data[index] <= data[left]) return;
            swap(data, index, left);
            shiftDown(left);//这步其实可以不要执行
        }
    }

    //通过入参传入的数组构造minHeap
    //1、常规思路就是讲数组中的元素一个的添加到堆中
    //2、我们只需要调整所有非叶子节点顺序,从最后一个非叶子节点开始依次做下沉操作
    public static MinHeap buildMinHeap(int[] array) {
        MinHeap minHeap = new MinHeap(array.length);
        minHeap.data = array;
        minHeap.size = array.length;
        int lastParentIndex = (array.length - 1) / 2;
        while (lastParentIndex >= 0) {
            minHeap.shiftDown(lastParentIndex);
            lastParentIndex--;
        }
        return minHeap;
    }

    //替换顶点元素
    //1、通常的思路就是先删除顶点元素,然后再加入replaceValue元素.时间复杂度为2次logn
    //2、优化方法直接将顶点元素替换为新元素,然后对顶点元素做下沉操作
    public int replace(int replaceValue) {
        if (isEmpty()) throw new IllegalArgumentException("堆为空");
        int min = data[0];
        data[0] = replaceValue;
        shiftDown(0);
        return min;
    }


    private int leftIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    //交换数组指定素
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(10);
        minHeap.add(1);

        minHeap.replace(-1);

        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());

        System.out.println("=====");


        MinHeap min = MinHeap.buildMinHeap(new int[]{5, 4, 31, -1});

        System.out.println(min.remove());
        System.out.println(min.remove());
        System.out.println(min.remove());
        System.out.println(min.remove());


    }


}
