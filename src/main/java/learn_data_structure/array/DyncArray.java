package learn_data_structure.array;

/**
 * 动态数组
 */
public class DyncArray {

    //动态数组默认初始化大小
    private static final int DEFAULT_SIZE = 10;
    //容量大小
    private int capacity;
    //存放数据的数组
    private int[] data;
    //容器实际元素个数
    private int size;

    public DyncArray(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public DyncArray() {
        this.capacity = DEFAULT_SIZE;
        this.data = new int[DEFAULT_SIZE];
    }

    public int getSize() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }


    public void addLast(int element) {
        addKth(size, element);
    }

    public void addKth(int index, int element) {
        checkAddIndex(index);
        checkResize();
        int end = size;
        int begin = index;
        for (int i = end; i > begin; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public void addFirst(int element) {
        addKth(0, element);
    }

    public void removeLast() {
        removeKth(size - 1);
    }

    //删除第k个元素
    public int removeKth(int removeIndex) {
        checkIndex(removeIndex);
        checkEmpty();
        int result = data[removeIndex];
        int begin = removeIndex;
        int end = size - 1;
        for (int i = begin; i < end; i++) {
            data[i] = data[i + 1];
        }
        size--;
        checkResize();
        return result;
    }

    public void removeFirst() {
        removeKth(0);
    }


    public int getKth(int index) {
        checkIndex(index);
        return data[index];
    }

    public void updateKth(int index, int value) {
        checkIndex(index);
        data[index] = value;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (element == data[i]) return true;
        }
        return false;
    }


    //调整容器数组大小(缩容或扩容)
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }

    private void checkResize() {
        if (size >= capacity - 1) {
            resize(capacity * 2);
        } else if (size < capacity / 2) {
            resize(capacity / 2 + 1);
        }
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("数组越界");
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("数组越界");
    }

    private void checkEmpty() {
        if (empty()) throw new IllegalStateException("空数组");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            stringBuilder.append(data[i] + "->");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        DyncArray dyncArray = new DyncArray(3);

        dyncArray.addLast(10);
        dyncArray.addFirst(1);
        dyncArray.addFirst(2);
        System.out.println(dyncArray.toString());

        dyncArray.addKth(1, 100);
        dyncArray.addKth(1, 99);
        System.out.println(dyncArray.toString());
        dyncArray.addKth(1, 45);
        System.out.println(dyncArray.toString());

        dyncArray.removeKth(3);
        dyncArray.removeFirst();
        dyncArray.removeLast();


        System.out.println(dyncArray.toString());

    }

}
