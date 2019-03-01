package learnData.unionfindset;

import java.util.Random;

/**
 * 路径压缩优化
 */
public class UFSet5 implements UFSet {

    private int[] data;


    public UFSet5(int size) {
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {

        int aset = findSet(a);
        int bset = findSet(b);
        if (aset == bset) return;
        data[a] = bset;
    }

    @Override
    public boolean isConnected(int a, int b) {
        return findSet(a) == findSet(b);
    }

    private int findSet(int element) {
        while (element != data[element]) {
            element = data[element];
            //核心算法-往根节点进一层
            data[element] = data[data[element]];
        }
        return data[element];
    }

    public static void main(String[] args) {


        int randomint = 1000000;
        int seed = randomint / 10;
        UFSet ufSet = new UFSet5(randomint);
        Random random = new Random(randomint);
        long start = System.currentTimeMillis();
        for (int i = 0; i < randomint; i++) {
            ufSet.union(random.nextInt(seed), random.nextInt(seed));
            ufSet.isConnected(random.nextInt(seed), random.nextInt(seed));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
