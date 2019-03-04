package learnData.code_training;

public class MaxHeap {


    private int[] datas;
    private int size;
    private static final int CAPACITY = 10;

    public MaxHeap() {
        datas = new int[CAPACITY];
    }

    public MaxHeap(int capacity) {
        datas = new int[capacity];
    }

    public void add(int data) {
        if (size == 0) {
            datas[0] = data;
            size++;
            return;
        }
        datas[size] = data;
        size++;
        shitUp(size - 1);

    }


    public int popMax() {
        return datas[0];
    }

    public int removeMax() {
        int max = datas[0];
        swap(datas, 0, size - 1);
        if (size == 1) return max;
        size--;
        shitDown(0);
        return max;
    }

    private void shitDown(int index) {

        int left = leftIndex(index);
        int right = rightIndex(index);
        int maxIndex = left;
        if (left <= size - 1) {
            if (right <= size - 1) {
                maxIndex = datas[left] > datas[right] ? left : right;
            }
            if (datas[maxIndex] > datas[index]) {
                swap(datas, index, maxIndex);
                shitDown(maxIndex);
            }
        }
    }

    private void shitUp(int index) {
        if (index == 0) return;
        int parentIndex = parentIndex(index);
        if (datas[parentIndex] < datas[index]) {
            swap(datas, parentIndex, index);
            shitUp(parentIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(datas[i] + "->");
        }
        return sb.toString();
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private int leftIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int rightIndex(int parentIndex) {
        return leftIndex(parentIndex) + 1;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }


    public static void main(String[] args) {


        MaxHeap maxHeap = new MaxHeap(100);

        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(50);

        System.out.println(maxHeap.popMax());
        System.out.println(maxHeap.toString());

        System.out.println("------");
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());

        System.out.println(maxHeap.size);
    }


}
