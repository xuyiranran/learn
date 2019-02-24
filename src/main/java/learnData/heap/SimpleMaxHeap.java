package learnData.heap;

/**
 * 大顶堆
 * 1、二叉堆满足完全二叉树
 * 2、父亲节点元素大于左右孩子节点元素
 *
 * @param <E>
 */
public class SimpleMaxHeap<E extends Comparable<? super E>> {

    private static final int DEFAULT_SIZE = 10;

    //存放元素数组
    private E[] data;
    //数组中元素个数
    private int size;

    public SimpleMaxHeap() {
        this(DEFAULT_SIZE);
    }

    public SimpleMaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element) {
        if (size == data.length) {
            ensureCapcity(2 * size + 1);
        }
        data[size] = element;
        size++;
        //如果只有一个节点直接返回
        if (size == 1) return;
        //上虑操作
        shitUp(size - 1);
    }

    /**
     * 上滤操作(孩子节点大于父亲节点)
     *
     * @param node
     */
    private void shitUp(int node) {
        //孩子节点大于父亲节点时需要交换位置.
        while (data[node].compareTo(data[parentIndex(node)]) > 0 && node > 0) {
            swap(data, node, parentIndex(node));
            node = parentIndex(node);
        }
    }

    /**
     * 弹出最大元素
     *
     * @return
     */
    public E popMax() {
        if (isEmpty()) throw new RuntimeException("空堆");
        E max = data[0];
        swap(data, 0, size - 1);
        size--;
        //如果只有一个节点无需操作
        if (size == 1) return max;
        //下沉操作
        shitDown(0);
        return max;
    }

    /**
     * 下沉操作
     *
     * @param root
     */
    private void shitDown(int root) {

        //1、达到最底端
        //2、寻找左右孩子节点较大的节点
        //3、交换父亲和孩子节点位置
        //由于二叉堆得性质定义完全二叉树,从左到右添加节点的.
        while (leftIndex(root) <= size - 1) {
            int left = leftIndex(root);//由于循环条件限制一定存在left子节点
            int right = left + 1;//right节点未必存在,所以在下面判断中要判断小于数组size或right必须为奇数
            int nextIndex = left;//暂时存储最大孩子下标
            if (right % 2 == 1 && data[right].compareTo(data[left]) > 0) {
                nextIndex = right;
            }
            //如果节点小于左右孩子的最大节点交换元素
            if (data[root].compareTo(data[nextIndex]) < 0) {
                swap(data, root, nextIndex);
                root = nextIndex;
            } else break;
        }
    }

    /**
     * 查看最大元素
     *
     * @return
     */
    public E peekMax() {
        if (size == 0) throw new RuntimeException("空堆");
        E max = data[0];
        return max;
    }

    /**
     * 父亲节点下标index
     *
     * @param index
     * @return
     */
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * 左孩子节点下标index
     *
     * @param index
     * @return
     */
    private int leftIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 扩容和缩容
     *
     * @param newCapcity
     */
    private void ensureCapcity(int newCapcity) {
        E[] newData = (E[]) new Comparable[newCapcity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 交换数组下标元素
     *
     * @param array
     * @param i
     * @param j
     */
    private void swap(E[] array, int i, int j) {
        if (i < 0 || i > array.length - 1 || j < 0 || j > array.length - 1) throw new IndexOutOfBoundsException("数组越界");
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static void main(String[] args) {
        SimpleMaxHeap maxHeap = new SimpleMaxHeap(10);

        maxHeap.add(34);
        maxHeap.add(20);
        maxHeap.add(1000);
        maxHeap.add(40);
        maxHeap.add(100);
        maxHeap.add(999);
        maxHeap.add(898);

        System.out.println(maxHeap.getSize());
        System.out.println(maxHeap.popMax());
        System.out.println(maxHeap.popMax());
        System.out.println(maxHeap.popMax());
        System.out.println(maxHeap.popMax());
        System.out.println(maxHeap.popMax());
        System.out.println(maxHeap.popMax());
        System.out.println(maxHeap.popMax());
    }
}
