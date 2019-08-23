package learn_training;

public class MinHeap {


    private int size;

    private int[] data;

    public MinHeap(int capacity) {
        data = new int[capacity];
    }


    public void add(int element) {
        data[size] = element;
        size++;
        up(data, 0);
    }

    private void up(int[] data, int index) {
        if (index == 0) return;
        while (index != 0 && data[index] > data[parent(index)]) {
            swap(data, index, parent(index));
            index = parent(index);
        }
    }


    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("");
        } else {
            int result = data[0];
            size--;
            swap(data, 0, size - 1);
            down(data, 0);
            return result;
        }

    }

    private void down(int[] data, int index) {

        if (size <= 1) return;
        while (index <= size) {
            int left = left(index);
            int right = left(index) + 1;
            int minIndex;
            if (right >= size) {
                minIndex = left;
            } else {
                minIndex = data[left] < data[right] ? left : right;
            }
            if (data[index] > data[minIndex]) {
                swap(data, index, minIndex);
                index = minIndex;
            } else {
                break;
            }
        }

    }

    public int peek() {
        return data[0];
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    private void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    private int parent(int index) {
        if (index == 0) return 0;
        return index - 1 / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }


    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);

        for (int i = 10; i > 0; i--) {
            minHeap.add(i);
        }

        System.out.println(minHeap.peek());

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.pop() + "、");
        }

    }


}
