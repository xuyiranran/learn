package learnData.unionfindset;

import java.util.Random;

/**
 * 基于size优化(集合size)
 */
public class UFSet3 implements UFSet {

    private int[] data;
    private int[] sizes;

    public UFSet3(int size) {
        data = new int[size];
        sizes=new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
            sizes[i] = 1;
        }
    }

    @Override
    public void union(int a, int b) {

        int aset = findSet(a);
        int bset = findSet(b);
        if (aset == bset) return;
        if (sizes[a] > sizes[b]) {
            data[b] = aset;
            sizes[b]++;
        } else {
            data[a] = bset;
            sizes[a]++;
        }

    }

    @Override
    public boolean isConnected(int a, int b) {
        return findSet(a) == findSet(b);
    }

    private int findSet(int element) {
        while (element != data[element]) {
            element = data[element];
        }
        return data[element];
    }

    public static void main(String[] args) {


        int randomint = 1000;
        int seed=randomint/10;
        UFSet ufSet = new UFSet3(randomint);
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
