package learnData.unionfindset;

import java.util.Random;

/**
 * 基于rank优化(即基于树高度作为参考来优化)
 */
public class UFSet4 implements UFSet {

    private int[] data;
    private int[] ranks;


    public UFSet4(int size) {
        data = new int[size];
        ranks = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
            ranks[i] = 1;
        }
    }

    @Override
    public void union(int a, int b) {

        int aset = findSet(a);
        int bset = findSet(b);
        if (aset == bset) return;
        int ranka = ranks[aset];
        int rankb = ranks[bset];
        if (ranka > rankb) {
            data[b] = aset;
        } else if (ranka < rankb) {
            data[a] = bset;
        } else {
            data[a] = bset;
            ranks[aset]++;
        }
    }

    @Override
    public boolean isConnected(int a, int b) {
        return findSet(a) == findSet(b);
    }

    private int findSet(int element) {
        while (element != data[element]) {
            element = data[element];
//            //往根节点进一层
//            data[element] = data[data[element]];
        }
        return data[element];
    }

    public static void main(String[] args) {


        int randomint = 1000000;
        int seed = randomint / 10;
        UFSet ufSet = new UFSet4(randomint);
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
