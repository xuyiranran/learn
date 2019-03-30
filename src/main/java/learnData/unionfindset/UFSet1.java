package learnData.unionfindset;

import java.util.Random;

/**
 * 直接基于数组实现没有任何优化
 *
 */
public class UFSet1 implements UFSet {

    private int[] array;

    public UFSet1(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }

    private int getSize() {
        return array.length;
    }

    @Override
    public void union(int a, int b) {
        int aset = findSet(a);
        int bset = findSet(b);
        //同一个集合,不需要union操作
        if (aset == bset) return;
        for (int i = 0; i <array.length; i++) {
            if (array[i]==aset){
                array[i]=bset;
            }
        }
    }

    private int findSet(int a) {
        if (a < 0 || a > array.length - 1) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        return array[a];
    }

    @Override
    public boolean isConnected(int a, int b) {
        return findSet(a) == findSet(b);
    }

    public static void main(String[] args) {


        int randomint = 100000;
        UFSet ufSet = new UFSet1(randomint);
        Random random = new Random(randomint);
        long start = System.currentTimeMillis();
        for (int i = 0; i < randomint; i++) {
            ufSet.union(random.nextInt(randomint), random.nextInt(randomint));
            ufSet.isConnected(random.nextInt(randomint), random.nextInt(randomint));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
